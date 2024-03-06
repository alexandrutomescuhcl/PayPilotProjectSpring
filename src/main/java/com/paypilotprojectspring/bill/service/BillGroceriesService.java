package com.paypilotprojectspring.bill.service;


import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.exception.BillException;
import com.paypilotprojectspring.bill.mapper.BillGroceriesMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import com.paypilotprojectspring.notification.mapper.ReminderSettingsMapper;
import com.paypilotprojectspring.notification.repository.ReminderRepository;
import jakarta.transaction.Transactional;
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
        if(!billList.isEmpty())
            return billGroceriesMapper.entitiesToDTOs(billList);
        else
            throw new BillException("This category does not exist.");
    }

    public Optional<BillGroceriesDTO> findById(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        if(bill.isPresent())
            return bill.map(billGroceriesMapper::entityToDTO);
        else
            throw new BillException("Bill id does not exist.");
    }

    @Transactional
    public void addBill(BillGroceriesDTO billGroceriesDTO){
        billRepository.save(billGroceriesMapper.dtoToEntity(billGroceriesDTO));
    }

    @Transactional
    public boolean updateBill(BillGroceriesDTO billGroceriesDTO, Long id){
        Optional<Bill> bill = billRepository.findByBillId(id);
        if(bill.isPresent()){
            BillGroceriesDTO existingBill = billGroceriesMapper.entityToDTO(bill.get());
            existingBill.setBillName(billGroceriesDTO.getBillName());
            existingBill.setBillCategory(billGroceriesDTO.getBillCategory());
            existingBill.setMonth(billGroceriesDTO.getMonth());
            existingBill.setSlNo(billGroceriesDTO.getSlNo());
            existingBill.setAmount(billGroceriesDTO.getAmount());
            existingBill.setReminderSettingsDTO(billGroceriesDTO.getReminderSettingsDTO());
            billRepository.save(billGroceriesMapper.dtoToEntity(existingBill));
            return true;
        }
        else
            throw new BillException("Bill id does not exist.");
    }

    public boolean deleteBill(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        if(bill.isPresent()){
            billRepository.deleteById(id);
            return true;
        }
        else
            throw new BillException("Bill id does not exist.");
    }

}
