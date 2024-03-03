package com.paypilotprojectspring.bank_details.mapper;

import com.paypilotprojectspring.bank_details.dto.BankDetailsDTO;
import com.paypilotprojectspring.bank_details.model.BankDetails;
import org.springframework.stereotype.Component;

@Component
public class BankDetailsMapper {

    public BankDetailsDTO entityToDto(BankDetails entity){
        if(entity == null){
            return null;
        }
        BankDetailsDTO dto = new BankDetailsDTO();

        dto.setBankDetailsId(entity.getBankDetailsId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setActive(entity.getActive());
        dto.setBic(entity.getBic());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setBankISFC(entity.getBankISFC());

        return dto;
    }

    public BankDetails dtoToEntity(BankDetailsDTO dto){
        if(dto == null){
            return null;
        }
        BankDetails entity = new BankDetails();

        entity.setBankDetailsId(dto.getBankDetailsId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setActive(dto.getActive());
        entity.setBic(dto.getBic());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setBankISFC(dto.getBankISFC());

        return entity;
    }
}
