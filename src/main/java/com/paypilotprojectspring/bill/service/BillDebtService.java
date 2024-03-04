package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillDebtDTO;
import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.mapper.BillDebtMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillDebtService {

    private final BillRepository billRepository;
    private final BillDebtMapper billDebtMapper;

    public List<BillDebtDTO> findAll(String category) {
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category));
        return billDebtMapper.entitiesToDTOs(billList);
    }

    public Optional<BillDebtDTO> findById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        return bill.map(billDebtMapper::entityToDTO);
    }

    public void addBill(BillDebtDTO billDebtDTO) {
        Bill bill = billDebtMapper.dtoToEntity(billDebtDTO);
        billRepository.save(bill);
    }

    public boolean updateBill(BillDebtDTO billDebtDTO, long id) {
        boolean result;
        Optional<Bill> optionalBill = billRepository.findById(id);
        result = optionalBill.isPresent();
        if (result) {

            BillDebtDTO existingBillDto = billDebtMapper.entityToDTO(optionalBill.get());
            existingBillDto.setBillName(billDebtDTO.getBillName());
            existingBillDto.setBillCategory(billDebtDTO.getBillCategory());
            existingBillDto.setAmount(billDebtDTO.getAmount());
            existingBillDto.setSlNo(billDebtDTO.getSlNo());
            existingBillDto.setMonth(billDebtDTO.getMonth());
            existingBillDto.setMonthlyEMI(billDebtDTO.getMonthlyEMI());
            existingBillDto.setTotalLoan(billDebtDTO.getTotalLoan());
            existingBillDto.setBillLoanType(billDebtDTO.getBillLoanType());
            existingBillDto.setFrom(billDebtDTO.getFrom());
            existingBillDto.setTo(billDebtDTO.getTo());
            existingBillDto.setDueDate(String.valueOf(billDebtDTO.getDueDate()));

            Bill bill = billDebtMapper.dtoToEntity(existingBillDto);
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
