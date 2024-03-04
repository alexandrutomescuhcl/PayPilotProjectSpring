package com.paypilotprojectspring.bill.repository;

import com.paypilotprojectspring.bill.model.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRentRepository extends CrudRepository<Bill, Long> {

    @Query(value = "SELECT b FROM Bill b WHERE b.billCategory = 'HOUSE_RENT'")
    List<Bill> findAll();

    Optional<Bill> findByBillId(Long id);


}
