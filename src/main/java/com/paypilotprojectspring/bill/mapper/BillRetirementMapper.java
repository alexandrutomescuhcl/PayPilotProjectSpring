package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillRetirementDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BillRetirementMapper {
    public BillRetirementDTO entityToDTO(Bill bill) {
        if (bill == null) {
            return null;
        }
        BillRetirementDTO billDTO = new BillRetirementDTO();

        billDTO.setBillId(bill.getBillId());
        billDTO.setBillName(bill.getBillName());
        billDTO.setBillCategory(bill.getBillCategory().toString());
        billDTO.setDueDate(bill.getDueDate());
        billDTO.setNotes(bill.getNotes());
        billDTO.setRecurrent(bill.isRecurrent());
        billDTO.setSlNo(bill.getSlNo());
        billDTO.setMonth(bill.getMonth());
        billDTO.setAmount(bill.getAmount());

        return billDTO;
    }

    public List<BillRetirementDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillRetirementDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(entityToDTO(bill));
        }
        return billDTOs;
    }

    public Bill dtoToEntity(BillRetirementDTO billDTO) {
        if (billDTO == null) {
            return null;
        }
        Bill billEntity = new Bill();

        billEntity.setBillId(billDTO.getBillId());
        billEntity.setBillName(billDTO.getBillName());
        billEntity.setBillCategory(BillCategory.valueOf(billDTO.getBillCategory()));
        billEntity.setDueDate(billDTO.getDueDate());
        billEntity.setNotes(billDTO.getNotes());
        billEntity.setRecurrent(billDTO.isRecurrent());
        billEntity.setSlNo(billDTO.getSlNo());
        billEntity.setMonth(billDTO.getMonth());
        billEntity.setAmount(billDTO.getAmount());

        return billEntity;
    }

    public List<Bill> dtosToEntities(List<BillRetirementDTO> billDTOs) {
        if (billDTOs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> billEntities = new ArrayList<>();
        for (BillRetirementDTO billDTO : billDTOs) {
            billEntities.add(dtoToEntity(billDTO));
        }
        return billEntities;
    }
}
