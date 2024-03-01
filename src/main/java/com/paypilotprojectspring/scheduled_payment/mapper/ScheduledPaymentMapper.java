package com.paypilotprojectspring.scheduled_payment.mapper;

import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPaymentMapper {
    public ScheduledPaymentDto entityToDTO(ScheduledPayment entity) {
        if (entity == null) {
            return null;
        }
        ScheduledPaymentDto dto = new ScheduledPaymentDto();

        dto.setId(entity.getId());
        dto.setBillDate(entity.getBillDate());
        dto.setEnabled(entity.getEnabled());
        dto.setBankDetailsId(entity.getBankDetailsId());
        dto.setBillId(entity.getBillId());
        dto.setPaymentFrequency(entity.getPaymentFrequency());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPurposeOfPayment(entity.getPurposeOfPayment());
        dto.setPayeeAddress(entity.getPayeeAddress());
        dto.setPayeeName(entity.getPayeeName());
        dto.setNameOfTheBill(dto.getNameOfTheBill());
        dto.setPayerAccount(entity.getPayerAccount());
        dto.setUserId(entity.getUserId());

        return dto;
    }

    public ScheduledPayment dtoToEntity(ScheduledPaymentDto dto) {
        if (dto == null) {
            return null;
        }
        ScheduledPayment entity = new ScheduledPayment();

        entity.setId(dto.getId());
        entity.setBillDate(dto.getBillDate());
        entity.setEnabled(dto.getEnabled());
        entity.setBankDetailsId(dto.getBankDetailsId());
        entity.setBillId(dto.getBillId());
        entity.setPaymentFrequency(dto.getPaymentFrequency());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setPurposeOfPayment(dto.getPurposeOfPayment());
        entity.setPayeeAddress(dto.getPayeeAddress());
        entity.setPayeeName(dto.getPayeeName());
        entity.setNameOfTheBill(dto.getNameOfTheBill());
        entity.setPayerAccount(dto.getPayerAccount());
        entity.setUserId(dto.getUserId());

        return entity;
    }
}
