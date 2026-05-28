package com.assignment.receiver.service;

import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.model.ReceivedEvent;
import com.assignment.receiver.repo.ReceiverRepository;
import com.assignment.receiver.util.EventMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.assignment.receiver.util.Constants.SAVED_IN_DB;


@Slf4j
@Service
@AllArgsConstructor
public class ReceiverService {

    private final ReceiverRepository receivedEventRepository;

    /**
     * Processes incoming event.
     *
     * @param payloadParam event data
     */
    public void processEvent(EventPayload payloadParam) {
        ReceivedEvent event = EventMapper.toEntity(payloadParam);
        receivedEventRepository.save(event);
        log.info(SAVED_IN_DB , event.getEventId());
    }
}
