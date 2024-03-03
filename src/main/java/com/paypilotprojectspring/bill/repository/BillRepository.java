package com.paypilotprojectspring.bill.repository;

import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> findBillsByBillCategory(BillCategory category);
    Optional<Bill> findByBillId(Long id);
}
