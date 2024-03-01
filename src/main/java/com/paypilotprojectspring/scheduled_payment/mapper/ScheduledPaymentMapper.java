package com.paypilotprojectspring.scheduled_payment.mapper;

import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.user.dto.UserDTO;
import com.paypilotprojectspring.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ScheduledPaymentMapper {
    public ScheduledPaymentDto entityToDTO(ScheduledPayment sp) {
        if (sp == null) {
            return null;
        }
        ScheduledPaymentDto spDto = new ScheduledPaymentDto();

        spDto.setBillDate(sp.getBillDate());
        spDto.setEnabled(sp.getEnabled());
        spDto.setBankDetailsId(sp.getBankDetailsId());
        spDto.setBillId(sp.getBillId());
        spDto.setPaymentFrequency(sp.getPaymentFrequency());
        spDto.setPaymentMethod(sp.getPaymentMethod());
        spDto.setPurposeOfPayment(sp.getPurposeOfPayment());
        spDto.setPayeeAddress(sp.getPayeeAddress());
        spDto.setPayeeName(spDto.getPayeeName());
        spDto.setNameOfTheBill(spDto.getNameOfTheBill());
        spDto.setPayerAccount(sp.getPayerAccount());
        spDto.setUserId(sp.getUserId());

        return spDto;
    }

    public ScheduledPayment dtoToEntity(ScheduledPaymentDto dto) {
        if (dto == null) {
            return null;
        }
        ScheduledPayment entity = new ScheduledPayment();

        entity.setBillDate(dto.getBillDate());
        entity.setEnabled(dto.getEnabled());
        entity.setBankDetailsId(dto.getBankDetailsId());
        entity.setBillId(dto.getBillId());
        entity.setPaymentFrequency(dto.getPaymentFrequency());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setPurposeOfPayment(dto.getPurposeOfPayment());
        entity.setPayeeAddress(dto.getPayeeAddress());
        entity.setPayeeName(entity.getPayeeName());
        entity.setNameOfTheBill(entity.getNameOfTheBill());
        entity.setPayerAccount(dto.getPayerAccount());
        entity.setUserId(dto.getUserId());

        return entity;
    }
}
