package com.assignment.receiver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "received_events")
public class ReceivedEvent {

    @Id
    private String eventId;

    private String userName;
    private String data;
    private LocalDateTime timestamp;


    public ReceivedEvent(String userNameParam, String eventIdParam, String dataParam, LocalDateTime timestampParam) {
        this.userName = userNameParam;
        this.eventId = eventIdParam;
        this.data = dataParam;
        this.timestamp = timestampParam;
    }

}