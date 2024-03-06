package com.paypilotprojectspring.scheduled_payment.mapper;

import com.paypilotprojectspring.bank_details.repository.BankDetailsRepository;
import com.paypilotprojectspring.bill.repository.BillRepository;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduledPaymentMapper {
    private final BillRepository billRepository;
    private final BankDetailsRepository bankDetailsRepository;
    private final UserRepository userRepository;

    public ScheduledPaymentMapper(BillRepository billRepository,
                                  BankDetailsRepository bankDetailsRepository, UserRepository userRepository) {
        this.billRepository = billRepository;
        this.bankDetailsRepository = bankDetailsRepository;
        this.userRepository = userRepository;
    }

    public ScheduledPaymentDto entityToDTO(ScheduledPayment entity) {
        if (entity == null) {
            return null;
        }
        ScheduledPaymentDto dto = new ScheduledPaymentDto();

        dto.setId(entity.getId());
        dto.setBillDate(entity.getBillDate());
        dto.setEnabled(entity.getEnabled());
        dto.setPaymentFrequency(entity.getPaymentFrequency());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPurposeOfPayment(entity.getPurposeOfPayment());
        dto.setPayeeAddress(entity.getPayeeAddress());
        dto.setPayeeName(entity.getPayeeName());
        dto.setNameOfTheBill(dto.getNameOfTheBill());
        dto.setPayerAccount(entity.getPayerAccount());

        return dto;
    }

    public ScheduledPayment dtoToEntity(ScheduledPaymentDto dto) {
        if (dto == null) {
            return null;
        }
        ScheduledPayment entity = new ScheduledPayment();
        Random rand = new Random();

        int randomNum = rand.nextInt(1000) + 1;
        entity.setId(randomNum);
        entity.setBillDate(dto.getBillDate());
        entity.setEnabled(dto.getEnabled());
        entity.setPaymentFrequency(dto.getPaymentFrequency());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setPurposeOfPayment(dto.getPurposeOfPayment());
        entity.setPayeeAddress(dto.getPayeeAddress());
        entity.setPayeeName(dto.getPayeeName());
        entity.setNameOfTheBill(dto.getNameOfTheBill());
        entity.setPayerAccount(dto.getPayerAccount());
        entity.setNextPaymentDate(dto.getNextPaymentDate());
        entity.setAmountToPay(dto.getAmountToPay());

        entity.setUserId(dto.getUserId());
        entity.setBankDetailsId(dto.getBankDetailsId());
        entity.setBillId(dto.getBillId());

        return entity;
    }
}
