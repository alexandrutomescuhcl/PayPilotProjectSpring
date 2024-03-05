package com.paypilotprojectspring.scheduled_payment.mapper;

import com.paypilotprojectspring.bank_details.model.BankDetails;
import com.paypilotprojectspring.bank_details.repository.BankDetailsRepository;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.user.model.User;
import com.paypilotprojectspring.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduledPaymentMapper {
    private final BillRepository billRepository;
    private final BankDetailsRepository bankDetailsRepository;
    private final UserRepository userRepository;

    public ScheduledPaymentMapper(BillRepository billRepository,
                                  BankDetailsRepository bankDetailsRepository, UserRepository userRepository) {
        this.billRepository = billRepository;
        this.bankDetailsRepository = bankDetailsRepository;
        this.userRepository = userRepository;
    }

    public ScheduledPaymentDto entityToDTO(ScheduledPayment entity) {
        if (entity == null) {
            return null;
        }
        ScheduledPaymentDto dto = new ScheduledPaymentDto();

        dto.setId(entity.getId());
        dto.setBillDate(entity.getBillDate());
        dto.setEnabled(entity.getEnabled());
        dto.setPaymentFrequency(entity.getPaymentFrequency());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPurposeOfPayment(entity.getPurposeOfPayment());
        dto.setPayeeAddress(entity.getPayeeAddress());
        dto.setPayeeName(entity.getPayeeName());
        dto.setNameOfTheBill(dto.getNameOfTheBill());
        dto.setPayerAccount(entity.getPayerAccount());

        dto.setUserId(entity.getUser().getId());
        dto.setBankDetailsId(entity.getBankDetails().getBankDetailsId());
        dto.setBillId(entity.getUser().getId());
        return dto;
    }

    public ScheduledPayment dtoToEntity(ScheduledPaymentDto dto) {
        if (dto == null) {
            return null;
        }
        ScheduledPayment entity = new ScheduledPayment();

        entity.setId(dto.getId());
        entity.setBillDate(dto.getBillDate());
        entity.setEnabled(dto.getEnabled());
        entity.setPaymentFrequency(dto.getPaymentFrequency());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setPurposeOfPayment(dto.getPurposeOfPayment());
        entity.setPayeeAddress(dto.getPayeeAddress());
        entity.setPayeeName(dto.getPayeeName());
        entity.setNameOfTheBill(dto.getNameOfTheBill());
        entity.setPayerAccount(dto.getPayerAccount());

//        Optional<Bill> targetBill = billRepository.findByBillId(dto.getBillId());
//        if (targetBill.isPresent()) {
//            entity.setBill(targetBill.get());
//        } else {
//            Bill newBill = new Bill();
//            newBill.setBillId(1L);
//            newBill.setBillCategory(BillCategory.HOUSE_RENT);
//
//            billRepository.save(newBill);
//            entity.setBill(newBill);
//
//        }
//
//        Optional<BankDetails> targetBankDetails = bankDetailsRepository.findById(dto.getBankDetailsId());
//        if (targetBankDetails.isPresent()) {
//            entity.setBankDetails(targetBankDetails.get());
//        } else {
//            BankDetails newBD = new BankDetails();
//            newBD.setBankDetailsId(1);
//
//            entity.setBankDetails(newBD);
//            bankDetailsRepository.save(newBD);
//        }
//
//        Optional<User> targetUser = userRepository.findById(dto.getUserId());
//        if (targetUser.isPresent()) {
//            entity.setUser(targetUser.get());
//        } else {
//            entity.setUser(new User());
//            entity.getUser().setId(1L);
//        }

        return entity;
    }
}
