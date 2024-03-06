package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillDebtDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.model.BillLoanType;
import com.paypilotprojectspring.notification.mapper.ReminderSettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BillDebtMapper {
    @Autowired
    private ReminderSettingsMapper reminderSettingsMapper;

    public BillDebtDTO entityToDTO(Bill bill) {
        if (bill == null) {
            return null;
        }
        BillDebtDTO billDTO = new BillDebtDTO();

        billDTO.setBillId(bill.getBillId());
        billDTO.setBillName(bill.getBillName());
        billDTO.setBillCategory(bill.getBillCategory().toString());
        billDTO.setAmount(bill.getAmount());
        billDTO.setSlNo(bill.getSlNo());
        billDTO.setMonth(bill.getMonth());
        billDTO.setMonthlyEMI(bill.getMonthlyEMI());
        billDTO.setTotalLoan(bill.getTotalLoan());
        billDTO.setBillLoanType(String.valueOf(bill.getBillLoanType()));
        billDTO.setFrom(String.valueOf(bill.getBillDateFrom()));
        billDTO.setTo(String.valueOf(bill.getBillDateTo()));
        billDTO.setDueDate(String.valueOf(bill.getDueDate()));
        billDTO.setReminderSettingsDTO(reminderSettingsMapper.toDTO(bill.getReminderSettings()));
        return billDTO;
    }

    public List<BillDebtDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillDebtDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(entityToDTO(bill));
        }
        return billDTOs;
    }

    public Bill dtoToEntity(BillDebtDTO billDTO) {
        if (billDTO == null) {
            return null;
        }
        Bill billEntity = new Bill();

        billEntity.setBillId(billDTO.getBillId());
        billEntity.setBillName(billDTO.getBillName());
        billEntity.setBillCategory(BillCategory.valueOf(billDTO.getBillCategory()));
        billEntity.setAmount(billDTO.getAmount());
        billEntity.setSlNo(billDTO.getSlNo());
        billEntity.setMonth(billDTO.getMonth());
        billEntity.setMonthlyEMI(billDTO.getMonthlyEMI());
        billEntity.setTotalLoan(billDTO.getTotalLoan());
        billEntity.setBillLoanType(BillLoanType.valueOf(billDTO.getBillLoanType()));
        billEntity.setBillDateFrom(LocalDate.parse(billDTO.getFrom()));
        billEntity.setBillDateTo(LocalDate.parse(billDTO.getTo()));
        billEntity.setDueDate(LocalDate.parse(billDTO.getDueDate()));
        billEntity.setReminderSettings(reminderSettingsMapper.toEntity(billDTO.getReminderSettingsDTO()));

        return billEntity;
    }

    public List<Bill> dtosToEntities(List<BillDebtDTO> billDTOs) {
        if (billDTOs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> billEntities = new ArrayList<>();
        for (BillDebtDTO billDTO : billDTOs) {
            billEntities.add(dtoToEntity(billDTO));
        }
        return billEntities;
    }
}
