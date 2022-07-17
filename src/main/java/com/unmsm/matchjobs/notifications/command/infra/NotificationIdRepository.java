package com.unmsm.matchjobs.notifications.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NotificationIdRepository extends JpaRepository<CustomerNotification, String> {

    Optional<CustomerNotification> getNotificationByNotificationId(String notificationId);

}
