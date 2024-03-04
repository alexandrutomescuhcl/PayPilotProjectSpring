package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillRentDTO;
import com.paypilotprojectspring.bill.mapper.BillRentMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillRentService {

    private final BillRepository billRepository;
    private final BillRentMapper billRentMapper;

    public List<BillRentDTO> findAll(String category) {
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category));
        return billRentMapper.entitiesToDTOs(billList);
    }

    public Optional<BillRentDTO> findById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        return bill.map(billRentMapper::entityToDTO);
    }

    public void addBill(BillRentDTO billRentDTO) {
        Bill bill = billRentMapper.dtoToEntity(billRentDTO);
        billRepository.save(bill);
    }

    public boolean updateBill(BillRentDTO billRentDTO, long id) {
        boolean result;
        Optional<Bill> optionalBill = billRepository.findById(id);
        result = optionalBill.isPresent();
        if (result) {

            BillRentDTO existingBillDto = billRentMapper.entityToDTO(optionalBill.get());
            existingBillDto.setBillName(billRentDTO.getBillName());
            existingBillDto.setBillCategory(billRentDTO.getBillCategory().toString());
            existingBillDto.setSlNo(billRentDTO.getSlNo());
            existingBillDto.setMonth(billRentDTO.getMonth());
            existingBillDto.setFrom(billRentDTO.getFrom());
            existingBillDto.setTo(billRentDTO.getTo());
            existingBillDto.setAmount(billRentDTO.getAmount());
            existingBillDto.setDueDate(String.valueOf(billRentDTO.getDueDate()));

            Bill bill = billRentMapper.dtoToEntity(existingBillDto);
            billRepository.save(bill);

        }
        return result;

    }

    public boolean deleteBill(Long id) {
        boolean result;
        Optional<Bill> optionalBill = billRepository.findById(id);
        result = optionalBill.isPresent();

        if (result) {
            billRepository.deleteById(id);
        }
        return result;
    }


}
