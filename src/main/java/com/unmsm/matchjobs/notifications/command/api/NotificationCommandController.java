package com.unmsm.matchjobs.notifications.command.api;

import com.unmsm.matchjobs.notifications.Common.ApiController;
import com.unmsm.matchjobs.notifications.Common.Result;
import com.unmsm.matchjobs.notifications.command.application.dtos.request.SendNotificationRequest;
import com.unmsm.matchjobs.notifications.command.application.dtos.response.SendNotificationResponse;
import com.unmsm.matchjobs.notifications.command.application.services.NotificationApplicationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Notification;


@RestController
@RequestMapping("/notifications")
@Tag(name = "Notifications")
public class NotificationCommandController {

    private final NotificationApplicationService notificationApplicationService;
    private final CommandGateway commandGateway;

    public NotificationCommandController(NotificationApplicationService notificationApplicationService, CommandGateway commandGateway) {
        this.notificationApplicationService = notificationApplicationService;
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerNotification(@RequestBody SendNotificationRequest sendNotificationRequest){
       try{
           Result<SendNotificationResponse, Notification> result = notificationApplicationService.registerNotification(sendNotificationRequest);
           return ApiController.created(result.getSuccess());
       } catch (Exception e){
           return ApiController.serverError();
       }
    }


}
