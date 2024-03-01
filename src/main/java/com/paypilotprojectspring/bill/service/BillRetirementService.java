package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.dto.BillRetirementDTO;
import com.paypilotprojectspring.bill.mapper.BillRetirementMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillRetirementService {

    private final BillRepository billRepository;
    private final BillRetirementMapper billRetirementMapper;

    public List<BillRetirementDTO> findAll(String category){
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category));
        return billRetirementMapper.entitiesToDTOs(billList);
    }

    public Optional<BillRetirementDTO> findById(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        return bill.map(billRetirementMapper::entityToDTO);
    }
}
