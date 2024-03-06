package com.paypilotprojectspring.notification.mapper;

import com.paypilotprojectspring.notification.dto.NotificationDTO;
import com.paypilotprojectspring.notification.dto.ReminderSettingsDTO;
import com.paypilotprojectspring.notification.model.Notification;
import com.paypilotprojectspring.notification.model.ReminderSettings;
import org.springframework.stereotype.Component;

@Component
public class ReminderSettingsMapper {
    public ReminderSettingsDTO toDTO(ReminderSettings reminderSettings) {
        if (reminderSettings == null) {
            return null;
        } else {
            ReminderSettingsDTO reminderSettingsDTO = new ReminderSettingsDTO();
            reminderSettingsDTO.setId(reminderSettings.getId());
            reminderSettingsDTO.setActive(reminderSettings.getActive());
            reminderSettingsDTO.setReminderFrequency(reminderSettings.getReminderFrequency());
            reminderSettingsDTO.setReminderStartDate(reminderSettings.getReminderStartDate());
            reminderSettingsDTO.setMessage(reminderSettings.getMessage());
            reminderSettingsDTO.setNotificationByEmail(reminderSettings.getNotificationByEmail());
            reminderSettingsDTO.setNotificationInApp(reminderSettings.getNotificationInApp());
            return reminderSettingsDTO;
        }
    }

    public ReminderSettings toEntity(ReminderSettingsDTO reminderSettingsDTO) {
        if (reminderSettingsDTO == null) {
            return null;
        } else {
            ReminderSettings reminderSettings = new ReminderSettings();
            reminderSettings.setId(reminderSettingsDTO.getId());
            reminderSettings.setActive(reminderSettingsDTO.getActive());
            reminderSettings.setReminderFrequency(reminderSettingsDTO.getReminderFrequency());
            reminderSettings.setReminderStartDate(reminderSettingsDTO.getReminderStartDate());
            reminderSettings.setMessage(reminderSettingsDTO.getMessage());
            reminderSettings.setNotificationByEmail(reminderSettingsDTO.getNotificationByEmail());
            reminderSettings.setNotificationInApp(reminderSettingsDTO.getNotificationInApp());
            return reminderSettings;
        }
    }
}
