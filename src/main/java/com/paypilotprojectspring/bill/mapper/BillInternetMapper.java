package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillInternetDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.notification.mapper.ReminderSettingsMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BillInternetMapper {

    private ReminderSettingsMapper reminderSettingsMapper;

    public BillInternetDTO entityToDTO(Bill bill) {
        if (bill == null) {
            return null;
        }

        return BillInternetDTO.builder()
                .billId(bill.getBillId())
                .billName(bill.getBillName())
                .billCategory(bill.getBillCategory().toString())
                .amount(bill.getAmount())
                .slNo(bill.getSlNo())
                .month(bill.getMonth())
                .from(String.valueOf(bill.getBillDateFrom()))
                .to(String.valueOf(bill.getBillDateTo()))
                .dueDate(String.valueOf(bill.getDueDate()))
                .reminderSettingsDTO(reminderSettingsMapper.toDTO(bill.getReminderSettings()))
                .build();
    }

    public List<BillInternetDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillInternetDTO> dtos = new ArrayList<>();
        for (Bill bill : bills) {
            dtos.add(entityToDTO(bill));
        }
        return dtos;
    }

    public Bill dtoToEntity(BillInternetDTO dto) {
        if (dto == null) {
            return null;
        }
        Bill bill = new Bill();

        bill.setBillId(dto.getBillId());
        bill.setBillName(dto.getBillName());
        bill.setBillCategory(BillCategory.valueOf(dto.getBillCategory()));
        bill.setAmount(dto.getAmount());
        bill.setSlNo(dto.getSlNo());
        bill.setMonth(dto.getMonth());
        bill.setBillDateFrom(LocalDate.parse(dto.getFrom()));
        bill.setBillDateTo(LocalDate.parse(dto.getTo()));
        bill.setDueDate(LocalDate.parse(dto.getDueDate()));
        bill.setReminderSettings(reminderSettingsMapper.toEntity(dto.getReminderSettingsDTO()));

        return bill;
    }

    public List<Bill> dtosToEntities(List<BillInternetDTO> dtos) {
        if (dtos.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> bills = new ArrayList<>();
        for (BillInternetDTO dto : dtos) {
            bills.add(dtoToEntity(dto));
        }
        return bills;
    }
}
