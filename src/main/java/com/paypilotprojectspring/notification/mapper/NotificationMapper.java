package com.paypilotprojectspring.notification.mapper;

import com.paypilotprojectspring.bill.mapper.BillBaseMapper;
import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    private final BillBaseMapper billBaseMapper;

    public NotificationMapper(BillBaseMapper billBaseMapper) {
        this.billBaseMapper = billBaseMapper;
    }

    public NotificationDTO toDTO(Notification notification) {
        if (notification == null) {
            return null;
        } else {
            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.setId(notification.getId());
            notificationDTO.setBill(billBaseMapper.toDTO(notification.getBill()));
            notificationDTO.setMessage(notification.getMessage());
            return notificationDTO;
        }
    }

    public Notification toEntity(NotificationDTO notificationDTO) {
        if (notificationDTO == null) {
            return null;
        } else {
            Notification notification = new Notification();
            notification.setBill(billBaseMapper.toEntity(notificationDTO.getBill()));
            notification.setMessage(notificationDTO.getMessage());
            return notification;
        }
    }
}
