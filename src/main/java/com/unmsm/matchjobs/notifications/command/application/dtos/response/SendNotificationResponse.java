package com.unmsm.matchjobs.notifications.command.application.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class SendNotificationResponse {
    private @Setter String from;
    private @Setter String to;
    private @Setter String subject;
    private @Setter String message;
}
