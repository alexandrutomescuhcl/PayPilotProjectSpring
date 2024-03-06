package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillBaseDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.notification.mapper.ReminderSettingsMapper;
import com.paypilotprojectspring.notification.model.ReminderSettings;

public class BillBaseMapper {
    private final ReminderSettingsMapper reminderSettingsMapper;

    public BillBaseMapper(ReminderSettingsMapper reminderSettingsMapper) {
        this.reminderSettingsMapper = reminderSettingsMapper;
    }

    public BillBaseDTO toDTO(Bill bill) {
        BillBaseDTO dto = new BillBaseDTO();
        dto.setBillId(bill.getBillId());
        dto.setBillName(bill.getBillName());
        dto.setBillCategory(bill.getBillCategory());
        dto.setAmount(bill.getAmount());
        dto.setBillDateFrom(bill.getBillDateFrom());
        dto.setBillDateTo(bill.getBillDateTo());
        if (bill.getReminderSettings() != null) {
            dto.setReminderSettings(reminderSettingsMapper.toDTO(bill.getReminderSettings()));
        }
        return dto;
    }

    public Bill toEntity(BillBaseDTO dto) {
        Bill bill = new Bill();
        bill.setBillId(dto.getBillId());
        bill.setBillName(dto.getBillName());
        bill.setBillCategory(dto.getBillCategory());
        bill.setAmount(dto.getAmount());
        bill.setBillDateFrom(dto.getBillDateFrom());
        bill.setBillDateTo(dto.getBillDateTo());
        if (dto.getReminderSettings() != null) {
            bill.setReminderSettings(reminderSettingsMapper.toEntity(dto.getReminderSettings()));
        }
        return bill;
    }
}
