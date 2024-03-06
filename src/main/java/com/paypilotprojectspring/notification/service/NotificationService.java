package com.paypilotprojectspring.notification.service;

import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.repository.BillRepository;
import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.mapper.NotificationMapper;
import com.paypilotprojectspring.notification.model.Notification;
import com.paypilotprojectspring.notification.model.ReminderFrequency;
import com.paypilotprojectspring.notification.model.ReminderSettings;
import com.paypilotprojectspring.notification.repository.NotificationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    private final NotificationMapper notificationMapper;

    private final BillRepository billRepository;


    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper, BillRepository billRepository) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.billRepository = billRepository;
    }

    public List<NotificationDTO> getNotifications() {
        List<Notification> notificationList = notificationRepository.findAll();
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        for (Notification notification : notificationList) {
            notificationDTOS.add(notificationMapper.toDTO(notification));
        }
        return notificationDTOS;
    }

    public NotificationDTO getNotificationById(Integer id) {
        if (notificationRepository.findById(id).isPresent())
            return notificationMapper.toDTO(notificationRepository.findById(id).get());
        return null;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void verifyUpcomingBills() {
        LocalDateTime now = LocalDateTime.now();
        List<Bill> billsList = (List<Bill>) billRepository.findAll();
        for (Bill bill : billsList) {
            ReminderSettings reminderSettings = bill.getReminderSettings();
            if (reminderSettings.getActive() && reminderSettings.getReminderStartDate().isBefore(now)) {
                Duration duration = Duration.between(reminderSettings.getReminderStartDate(), now);
                long daysSinceStart = duration.toDays();
                if (reminderSettings.getReminderFrequency().equals(ReminderFrequency.DAILY) ||
                        (reminderSettings.getReminderFrequency().equals(ReminderFrequency.WEEKLY) && daysSinceStart % 7 == 0) ||
                        (reminderSettings.getReminderFrequency().equals(ReminderFrequency.BIMONTHLY) && daysSinceStart % 14 == 0) ||
                        (reminderSettings.getReminderFrequency().equals(ReminderFrequency.MONTHLY) && daysSinceStart % 30 == 0)) {
                    Notification notification = new Notification();
                    notification.setBill(bill);
                    notification.setMessage(reminderSettings.getMessage());
                    notificationRepository.save(notification);
                }
            }
        }
    }
}
