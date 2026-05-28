package com.assignment.receiver.util;

import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.model.ReceivedEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventMapperTest {

    @Test
    void shouldMapEventPayloadToReceivedEvent() {

        // Arrange
        EventPayload payload = new EventPayload();
        payload.setUserName("Panchali");
        payload.setEventId("123");
        payload.setData("Test data");
        payload.setTimestamp(LocalDateTime.now());

        // Act
        ReceivedEvent result = EventMapper.toEntity(payload);

        // Assert
        assertNotNull(result);
        assertEquals("Panchali", result.getUserName());
        assertEquals("123", result.getEventId());
        assertEquals("Test data", result.getData());
        assertEquals(payload.getTimestamp(), result.getTimestamp());
    }
}