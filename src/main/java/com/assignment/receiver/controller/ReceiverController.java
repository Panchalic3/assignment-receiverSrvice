package com.assignment.receiver.controller;

import com.assignment.receiver.model.EventPayload;
import com.assignment.receiver.service.ReceiverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.assignment.receiver.util.Constants.PROCESSED_SUCCESSFULLY_LOG;
import static com.assignment.receiver.util.Constants.RECEIVED_EVENT_LOG;


@RestController
@RequestMapping("/api")
@Slf4j
public class ReceiverController {

    @Autowired
    ReceiverService service;

    /**
     * Receives event data from consumer service.
     *
     * @param payloadParam event data
     * @return success response
     */
    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody EventPayload payloadParam) {

        log.info(RECEIVED_EVENT_LOG, payloadParam.getEventId());
        service.processEvent(payloadParam);

        return ResponseEntity.ok(PROCESSED_SUCCESSFULLY_LOG);
    }
}
