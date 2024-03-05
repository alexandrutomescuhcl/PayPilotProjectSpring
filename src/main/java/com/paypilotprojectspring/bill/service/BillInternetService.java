package com.paypilotprojectspring.bill.service;

import com.paypilotprojectspring.bill.dto.BillInternetDTO;
import com.paypilotprojectspring.bill.exception.BillException;
import com.paypilotprojectspring.bill.mapper.BillInternetMapper;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillInternetService {
    private final BillRepository billRepository;
    private final BillInternetMapper billInternetMapper;

    public List<BillInternetDTO> findAll(String category) {
        List<Bill> billList = billRepository.findBillsByBillCategory(BillCategory.valueOf(category.toUpperCase()));
        if (!billList.isEmpty())
            return billInternetMapper.entitiesToDTOs(billList);
        else
            throw new BillException("No bills found in the INTERNET category.");
    }

    public Optional<BillInternetDTO> findById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent())
            return Optional.ofNullable(billInternetMapper.entityToDTO(bill.get()));
        else
            throw new BillException("Bill id does not exist.");
    }

    public void addBill(BillInternetDTO billInternetDTO) {
        billRepository.save(billInternetMapper.dtoToEntity(billInternetDTO));
    }

    public boolean updateBill(BillInternetDTO billInternetDTO, Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            billRepository.save(billInternetMapper.dtoToEntity(billInternetDTO));
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
