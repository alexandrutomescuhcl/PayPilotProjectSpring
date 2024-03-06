package com.paypilotprojectspring.scheduled_payment.service;

import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.repository.BillRepository;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentUpdateDateDto;
import com.paypilotprojectspring.scheduled_payment.mapper.ScheduledPaymentMapper;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.scheduled_payment.repository.ScheduledPaymentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ScheduledPaymentServiceImpl implements ScheduledPaymentService {

    private final ScheduledPaymentRepository scheduledPaymentRepository;
    private final ScheduledPaymentMapper scheduledPaymentMapper;
    private final BillRepository billRepository;

    public ScheduledPaymentServiceImpl(ScheduledPaymentRepository scheduledPaymentRepository,
                                       BillRepository billRepository,
                                       ScheduledPaymentMapper scheduledPaymentMapper) {
        this.scheduledPaymentRepository = scheduledPaymentRepository;
        this.billRepository = billRepository;
        this.scheduledPaymentMapper = scheduledPaymentMapper;
    }

    @Override
    public ScheduledPayment createScheduledPayment(ScheduledPaymentDto dto) {
        ScheduledPayment newScheduledPayment = scheduledPaymentMapper.dtoToEntity(dto);

        return scheduledPaymentRepository.save(newScheduledPayment);
    }

    @Override
    public ScheduledPayment cancelScheduledPayment(int id) {
        Optional<ScheduledPayment> targetScheduledPayment = scheduledPaymentRepository.findById(id);

        if (targetScheduledPayment.isPresent()) {
            targetScheduledPayment.get().setEnabled(false);
            return scheduledPaymentRepository.save(targetScheduledPayment.get());
        }

        return null;
    }

    @Override
    public ScheduledPayment modifyScheduleDate(int id, ScheduledPaymentUpdateDateDto dto) {
        Optional<ScheduledPayment> targetScheduledPayment = scheduledPaymentRepository.findById(id);
        if (targetScheduledPayment.isPresent()) {
            targetScheduledPayment.get().setBillDate(dto.getBillDate());
            return scheduledPaymentRepository.save(targetScheduledPayment.get());
        }

        return null;
    }

    @Override
    public List<ScheduledPayment> getAll() {
        return scheduledPaymentRepository.findAll();
    }

    public List<ScheduledPayment> findPaymentsForToday() {
        String today = LocalDate.now().toString();
        return scheduledPaymentRepository.findScheduledPaymentsByDate(today);
    }

    public void processPayment(ScheduledPayment payment) {
        Optional<Bill> targetBill = billRepository.findByBillId(payment.getBillId());
        if(targetBill.isPresent()) {
            targetBill.get().setDue_amount(targetBill.get().getDue_amount()-payment.getAmountToPay());
            billRepository.save(targetBill.get());
        } else {
            throw new RuntimeException("No bill with given id was found!");
        }
    }

    @Scheduled(cron = "0 0 0 * * ?") // Runs at midnight every day
    public void processScheduledPaymentsForToday() {
        List<ScheduledPayment> paymentsForToday = findPaymentsForToday();
        for (ScheduledPayment payment : paymentsForToday) {
            processPayment(payment);
        }
    }
}
