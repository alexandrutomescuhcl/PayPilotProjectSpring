package com.paypilotprojectspring.bank_details.repository;

import com.paypilotprojectspring.bank_details.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer> {
    Optional<BankDetails> findBankDetailsByName(String name);
}
