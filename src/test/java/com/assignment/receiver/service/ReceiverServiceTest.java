package com.assignment.receiver.service;

import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.model.ReceivedEvent;
import com.assignment.receiver.repo.ReceiverRepository;
import com.assignment.receiver.util.EventMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReceiverServiceTest {

    @Mock
    private ReceiverRepository receivedEventRepository;

    @InjectMocks
    private ReceiverService receiverService;

    @Test
    void shouldProcessAndSaveEventSuccessfully() {

        EventPayload payload = new EventPayload();
        payload.setEventId("123");

        ReceivedEvent mappedEvent = new ReceivedEvent();
        mappedEvent.setEventId("123");

        try (MockedStatic<EventMapper> mockedMapper = mockStatic(EventMapper.class)) {

            mockedMapper.when(() -> EventMapper.toEntity(payload))
                    .thenReturn(mappedEvent);

            receiverService.processEvent(payload);

            verify(receivedEventRepository).save(mappedEvent);
        }
    }
}
