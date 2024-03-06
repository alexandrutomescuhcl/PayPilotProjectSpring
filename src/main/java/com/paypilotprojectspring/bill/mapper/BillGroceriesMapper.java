package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BillGroceriesMapper {
    public BillGroceriesDTO entityToDTO(Bill bill) {
        if (bill == null) {
            return null;
        }
        BillGroceriesDTO billDTO = new BillGroceriesDTO();

        billDTO.setBillId(bill.getId());
        billDTO.setBillName(bill.getBillName());
        billDTO.setBillCategory(bill.getBillCategory().toString());
        billDTO.setSlNo(bill.getSlNo());
        billDTO.setMonth(bill.getMonth());
        billDTO.setAmount(bill.getAmount());

        return billDTO;
    }

    public List<BillGroceriesDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillGroceriesDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(entityToDTO(bill));
        }
        return billDTOs;
    }

    public Bill dtoToEntity(BillGroceriesDTO billDTO) {
        if (billDTO == null) {
            return null;
        }
        Bill billEntity = new Bill();

        billEntity.setId(billDTO.getBillId());
        billEntity.setBillName(billDTO.getBillName());
        billEntity.setBillCategory(BillCategory.valueOf(billDTO.getBillCategory()));
        billEntity.setSlNo(billDTO.getSlNo());
        billEntity.setMonth(billDTO.getMonth());
        billEntity.setAmount(billDTO.getAmount());

        return billEntity;
    }

    public List<Bill> dtosToEntities(List<BillGroceriesDTO> billDTOs) {
        if (billDTOs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> billEntities = new ArrayList<>();
        for (BillGroceriesDTO billDTO : billDTOs) {
            billEntities.add(dtoToEntity(billDTO));
        }
        return billEntities;
    }
}
