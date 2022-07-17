package com.unmsm.matchjobs.notifications.command.application.services;

import com.unmsm.matchjobs.notifications.Common.Result;
import com.unmsm.matchjobs.notifications.command.application.dtos.request.SendNotificationRequest;
import com.unmsm.matchjobs.notifications.command.application.dtos.response.SendNotificationResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import javax.management.Notification;

@Component
public class NotificationApplicationService {

    private final CommandGateway commandGateway;

    public NotificationApplicationService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Result<SendNotificationResponse, Notification> registerNotification(SendNotificationRequest sendNotificationRequest) throws Exception{
        SendNotificationResponse sendNotificationResponse = new SendNotificationResponse(
                "FROM",
                "TO",
                "SUBJECT",
                "MESSAGE"
        );
        return Result.success(sendNotificationResponse);
    }

    public Result<SendNotificationResponse, Notification> getNotifications(SendNotificationRequest sendNotificationRequest) throws Exception{
        SendNotificationResponse sendNotificationResponse = new SendNotificationResponse(
                "FROM2",
                "TO2",
                "SUBJECT2",
                "MESSAGE2"
        );
        return Result.success(sendNotificationResponse);
    }



}
