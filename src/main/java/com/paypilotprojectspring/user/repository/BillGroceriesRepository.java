package com.paypilotprojectspring.user.repository;

import com.paypilotprojectspring.user.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillGroceriesRepository extends CrudRepository<Bill, Long> {

    @Query(value="SELECT b FROM Bill b WHERE b.billCategory = 'GROCERIES'")
    List<Bill> findAll();

    Optional<Bill> findByBillId(Long id);
}
