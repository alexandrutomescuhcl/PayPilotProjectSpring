package com.paypilotprojectspring.scheduled_payment.service;

import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentUpdateDateDto;
import com.paypilotprojectspring.scheduled_payment.mapper.ScheduledPaymentMapper;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.scheduled_payment.repository.ScheduledPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScheduledPaymentServiceImpl implements ScheduledPaymentService {

    private final ScheduledPaymentRepository scheduledPaymentRepository;
    private final ScheduledPaymentMapper scheduledPaymentMapper;

    public ScheduledPaymentServiceImpl(ScheduledPaymentRepository scheduledPaymentRepository, ScheduledPaymentMapper scheduledPaymentMapper) {
        this.scheduledPaymentRepository = scheduledPaymentRepository;
        this.scheduledPaymentMapper = scheduledPaymentMapper;
    }

    @Override
    public ScheduledPayment createScheduledPayment(ScheduledPaymentDto dto) {
        ScheduledPayment newScheduledPayment =  scheduledPaymentMapper.dtoToEntity(dto);
        newScheduledPayment.setId(1); //todo: autogenerate id

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
}
