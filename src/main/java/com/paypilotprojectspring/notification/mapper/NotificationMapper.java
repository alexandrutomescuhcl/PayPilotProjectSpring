package com.paypilotprojectspring.notification.mapper;

import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public NotificationDTO toDTO(Notification notification) {
        if (notification == null) {
            return null;
        } else {
            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.setId(notification.getId());
            notificationDTO.setBill(notification.getBill());
            notificationDTO.setReminderFrequency(notification.getReminderFrequency());
            notificationDTO.setReminderStartDate(notification.getReminderStartDate());
            notificationDTO.setMessage(notification.getMessage());
            notificationDTO.setNotificationByEmail(notification.getNotificationByEmail());
            notificationDTO.setNotificationInApp(notification.getNotificationInApp());
            return notificationDTO;
        }
    }

    public Notification toEntity(NotificationDTO notificationDTO) {
        if (notificationDTO == null) {
            return null;
        } else {
            Notification notification = new Notification();
            notification.setBill(notificationDTO.getBill());
            notification.setReminderFrequency(notificationDTO.getReminderFrequency());
            notification.setReminderStartDate(notificationDTO.getReminderStartDate());
            notification.setMessage(notificationDTO.getMessage());
            notification.setNotificationByEmail(notificationDTO.getNotificationByEmail());
            notification.setNotificationInApp(notificationDTO.getNotificationInApp());
            return notification;
        }
    }
}
