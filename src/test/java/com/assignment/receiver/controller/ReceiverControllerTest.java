package com.assignment.receiver.controller;

import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.service.ReceiverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.assignment.receiver.util.Constants.PROCESSED_SUCCESSFULLY_LOG;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReceiverController.class)
class ReceiverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiverService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldProcessEventSuccessfully() throws Exception {

        EventPayload payload = new EventPayload();
        payload.setEventId("123");

        mockMvc.perform(post("/api/process")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isOk())
                .andExpect(content().string(PROCESSED_SUCCESSFULLY_LOG));

        // Verify service call
        verify(service).processEvent(any(EventPayload.class));    }
}