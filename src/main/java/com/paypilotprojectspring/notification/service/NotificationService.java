package com.paypilotprojectspring.notification.service;

import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.mapper.NotificationMapper;
import com.paypilotprojectspring.notification.model.Notification;
import com.paypilotprojectspring.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    private final NotificationMapper notificationMapper;


    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
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
}
