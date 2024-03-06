package com.paypilotprojectspring.notification.repository;

import com.paypilotprojectspring.notification.model.Notification;
import com.paypilotprojectspring.notification.model.ReminderSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderSettings, Integer> {

}
