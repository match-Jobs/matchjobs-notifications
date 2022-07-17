package com.unmsm.matchjobs.notifications.command.infra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerNotification {

    @Id
    @Column(length = 8)
    public String notificationId;

    public CustomerNotification(){

    }

    public CustomerNotification(String id){
        this.notificationId = id;
    }

    public String getId() {
        return notificationId;
    }

    public void setId(String id) {
        this.notificationId = id;
    }
}
