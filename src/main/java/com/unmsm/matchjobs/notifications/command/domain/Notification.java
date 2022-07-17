package com.unmsm.matchjobs.notifications.command.domain;

import com.unmsm.matchjobs.notifications.Contracts.commands.RegisterNotification;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.unmsm.matchjobs.notifications.Contracts.events.NotificationRegistered;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import java.time.Instant;


public class Notification {

    @AggregateIdentifier
    private String notificationId;

    public Notification() {
    }

    @CommandHandler
    public Notification(RegisterNotification command){
        Instant now = Instant.now();
        apply(
            new NotificationRegistered(
                command.getNotificationId()
            )
        );
    }


}
