package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillRentDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class BillRentMapper {

    public BillRentDTO entityToDTO(Bill bill) {

        if (bill == null) {
            return null;
        }

        BillRentDTO billRentDTO = new BillRentDTO();
        billRentDTO.setBillId(bill.getBillId());
        billRentDTO.setBillName(bill.getBillName());
        billRentDTO.setBillCategory(bill.getBillCategory().toString());
        billRentDTO.setSlNo(bill.getSlNo());
        billRentDTO.setMonth(bill.getMonth());
        billRentDTO.setFrom(String.valueOf(bill.getBillDateFrom()));
        billRentDTO.setTo(String.valueOf(bill.getBillDateTo()));
        billRentDTO.setAmount(bill.getAmount());
        billRentDTO.setDueDate(String.valueOf(bill.getDueDate()));

        return billRentDTO;

    }

    public List<BillRentDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillRentDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(entityToDTO(bill));
        }
        return billDTOs;
    }

    public Bill dtoToEntity(BillRentDTO billDTO) {
        if (billDTO == null) {
            return null;
        }
        Bill billEntity = new Bill();

        billEntity.setBillId(billDTO.getBillId());
        billEntity.setBillName(billDTO.getBillName());
        billEntity.setBillCategory(BillCategory.valueOf(billDTO.getBillCategory()));
        billEntity.setSlNo(billDTO.getSlNo());
        billEntity.setMonth(billDTO.getMonth());
        billEntity.setBillDateFrom(LocalDate.parse(billDTO.getFrom()));
        billEntity.setBillDateTo(LocalDate.parse(billDTO.getTo()));
        billEntity.setAmount(billDTO.getAmount());
        billEntity.setDueDate(LocalDate.parse(billDTO.getDueDate()));

        return billEntity;
    }

    public List<Bill> dtosToEntities(List<BillRentDTO> billDTOs) {
        if (billDTOs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> billEntities = new ArrayList<>();
        for (BillRentDTO billDTO : billDTOs) {
            billEntities.add(dtoToEntity(billDTO));
        }
        return billEntities;
    }

}
