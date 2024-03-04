package com.paypilotprojectspring.notification.controller;

import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.service.NotificationService;
import com.paypilotprojectspring.user.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<NotificationDTO> getAll() {
        return notificationService.getNotifications();
    }

    @GetMapping("/{id}")
    public NotificationDTO getById(@PathVariable Integer id) {
        return notificationService.getNotificationById(id);
    }
}
