package com.unmsm.matchjobs.notifications.config;

import com.unmsm.matchjobs.notifications.command.domain.Notification;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.modelling.command.Repository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    @Bean
    public Repository<Notification> eventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository.builder(Notification.class)
                .eventStore(eventStore)
                .build();
    }
}