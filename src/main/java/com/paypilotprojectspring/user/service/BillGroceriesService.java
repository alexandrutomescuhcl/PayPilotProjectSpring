package com.paypilotprojectspring.user.service;

import com.paypilotprojectspring.user.dto.BillGroceriesDTO;
import com.paypilotprojectspring.user.mapper.BillGroceriesMapper;
import com.paypilotprojectspring.user.model.Bill;
import com.paypilotprojectspring.user.repository.BillGroceriesRepository;
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
