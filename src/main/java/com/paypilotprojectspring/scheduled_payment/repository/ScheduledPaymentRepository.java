package com.paypilotprojectspring.scheduled_payment.repository;

import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledPaymentRepository extends JpaRepository<ScheduledPayment, Integer> {
}
