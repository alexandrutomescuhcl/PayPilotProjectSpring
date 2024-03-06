package com.paypilotprojectspring.scheduled_payment.repository;

import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduledPaymentRepository extends JpaRepository<ScheduledPayment, Integer> {
    @Query("SELECT sp FROM ScheduledPayment sp WHERE sp.nextPaymentDate = :today AND sp.enabled = true")
    List<ScheduledPayment> findScheduledPaymentsByDate(String today);
}
