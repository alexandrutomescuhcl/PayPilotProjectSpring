package com.paypilotprojectspring.bill.mapper;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.dto.BillRequestDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.model.BillStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BillRequestDTOMapper {

    public BillRequestDTO entityToDTO(Bill bill) {
        if (bill == null) {
            return null;
        }
        BillRequestDTO billRequestDTO = new BillRequestDTO();

        billRequestDTO.setBillStatus(bill.getBillStatus().toString());
        billRequestDTO.setDateFrom(bill.getBillDateFrom());
        billRequestDTO.setBillCategory(bill.getBillCategory().toString());
        billRequestDTO.setDateTo(bill.getBillDateTo());

        return billRequestDTO;
    }

    public List<BillRequestDTO> entitiesToDTOs(List<Bill> bills) {
        if (bills.isEmpty()) {
            return Collections.emptyList();
        }
        List<BillRequestDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(entityToDTO(bill));
        }
        return billDTOs;
    }

    public Bill dtoToEntity(BillRequestDTO billRequestDTO) {
        if (billRequestDTO == null) {
            return null;
        }
        Bill billEntity = new Bill();

        billEntity.setBillStatus(BillStatus.valueOf(billRequestDTO.getBillStatus()));
        billEntity.setBillDateFrom(billRequestDTO.getDateFrom());
        billEntity.setBillCategory(BillCategory.valueOf(billRequestDTO.getBillCategory()));
        billEntity.setBillDateTo(billRequestDTO.getDateTo());


        return billEntity;
    }

    public List<Bill> dtosToEntities(List<BillRequestDTO> billDTOs) {
        if (billDTOs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Bill> billEntities = new ArrayList<>();
        for (BillRequestDTO billDTO : billDTOs) {
            billEntities.add(dtoToEntity(billDTO));
        }
        return billEntities;
    }

}
