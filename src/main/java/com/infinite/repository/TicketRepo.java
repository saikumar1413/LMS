package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.model.TicketPojo;


@Repository //Responsible for database interactions
public interface TicketRepo extends JpaRepository<TicketPojo, Long> {
}

