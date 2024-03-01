package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.mapper.BillGroceriesMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.repository.BillGroceriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillGroceriesService {
    private final BillGroceriesRepository billRepository;
    private final BillGroceriesMapper billGroceriesMapper;

    public List<BillGroceriesDTO> findAll(){
        List<Bill> billList = billRepository.findAll();
        return billGroceriesMapper.entitiesToDTOs(billList);
    }

    public Optional<BillGroceriesDTO> findById(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        return bill.map(billGroceriesMapper::entityToDTO);
    }

}
