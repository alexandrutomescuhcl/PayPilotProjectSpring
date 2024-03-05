package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillCellphoneDTO;
import com.paypilotprojectspring.bill.exception.BillException;
import com.paypilotprojectspring.bill.mapper.BillCellphoneMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillCellphoneService {
    private final BillRepository billRepository;
    private final BillCellphoneMapper billCellphoneMapper;

    public List<BillCellphoneDTO> findAll(String category) {
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category.toUpperCase()));
        if (!billList.isEmpty())
            return billCellphoneMapper.entitiesToDTOs(billList);
        else
            throw new BillException("No bills found in the CELLPHONE category.");
    }

    public Optional<BillCellphoneDTO> findById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent())
            return Optional.ofNullable(billCellphoneMapper.entityToDTO(bill.get()));
        else
            throw new BillException("Bill id does not exist.");
    }

    public void addBill(BillCellphoneDTO billCellphoneDTO) {
        billRepository.save(billCellphoneMapper.dtoToEntity(billCellphoneDTO));
    }

    public boolean updateBill(BillCellphoneDTO billCellphoneDTO, Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            billRepository.save(billCellphoneMapper.dtoToEntity(billCellphoneDTO));
            return true;
        } else {
            throw new BillException("Bill id does not exist.");
        }
    }

    public boolean deleteBill(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            billRepository.deleteById(id);
            return true;
        } else {
            throw new BillException("Bill id does not exist.");
        }
    }
}
