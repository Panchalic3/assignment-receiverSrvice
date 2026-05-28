package com.assignment.receiver.util;


import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.model.ReceivedEvent;

public class EventMapper {

    /**
     * Maps EventPayload to ReceivedEvent entity.
     *
     * @param payloadParam incoming event payload
     * @return mapped ReceivedEvent entity
     */
    public static ReceivedEvent toEntity(EventPayload payloadParam) {
        return new ReceivedEvent(
                payloadParam.getUserName(),
                payloadParam.getEventId(),
                payloadParam.getData(),
                payloadParam.getTimestamp()
        );
    }
}