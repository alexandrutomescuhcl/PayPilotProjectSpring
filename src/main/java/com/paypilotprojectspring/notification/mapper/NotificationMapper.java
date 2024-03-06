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
            notificationDTO.setMessage(notification.getMessage());
            return notificationDTO;
        }
    }

    public Notification toEntity(NotificationDTO notificationDTO) {
        if (notificationDTO == null) {
            return null;
        } else {
            Notification notification = new Notification();
            notification.setBill(notificationDTO.getBill());
            notification.setMessage(notificationDTO.getMessage());
            return notification;
        }
    }
}
