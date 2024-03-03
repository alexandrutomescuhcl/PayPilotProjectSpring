package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.mapper.BillGroceriesMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillGroceriesService {
    private final BillRepository billRepository;
    private final BillGroceriesMapper billGroceriesMapper;

    public List<BillGroceriesDTO> findAll(String category){
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category));
        return billGroceriesMapper.entitiesToDTOs(billList);
    }

    public Optional<BillGroceriesDTO> findById(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        return bill.map(billGroceriesMapper::entityToDTO);
    }

}
