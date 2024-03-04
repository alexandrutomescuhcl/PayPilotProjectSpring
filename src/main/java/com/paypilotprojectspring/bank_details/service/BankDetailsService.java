package com.paypilotprojectspring.bank_details.service;

import com.paypilotprojectspring.bank_details.dto.BankDetailsDTO;
import com.paypilotprojectspring.bank_details.mapper.BankDetailsMapper;
import com.paypilotprojectspring.bank_details.model.BankDetails;
import com.paypilotprojectspring.bank_details.repository.BankDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankDetailsService {
    private final BankDetailsRepository bankDetailsRepository;
    private final BankDetailsMapper bankDetailsMapper;

    public Optional<BankDetailsDTO> findByBankDetailId(int id){
        Optional<BankDetails> bankDetails = bankDetailsRepository.findById(id);
        return bankDetails.map(bankDetailsMapper::entityToDto);
    }

    public Optional<BankDetailsDTO> findBankDetailsByName(String name){
        Optional<BankDetails> bankDetails = bankDetailsRepository.findBankDetailsByName(name);
        return bankDetails.map(bankDetailsMapper::entityToDto);
    }

    public List<BankDetails> getAll() {
        return bankDetailsRepository.findAll();
    }
}
