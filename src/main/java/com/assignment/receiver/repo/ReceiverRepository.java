package com.assignment.receiver.repo;

import com.assignment.receiver.model.ReceivedEvent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReceiverRepository  extends JpaRepository<ReceivedEvent, Long> {

}

