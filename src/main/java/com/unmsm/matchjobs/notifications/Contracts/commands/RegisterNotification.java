package com.unmsm.matchjobs.notifications.Contracts.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class RegisterNotification {
    @TargetAggregateIdentifier
    private String notificationId;
}
