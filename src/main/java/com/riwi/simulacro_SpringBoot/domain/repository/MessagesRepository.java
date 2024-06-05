package com.riwi.simulacro_SpringBoot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.simulacro_SpringBoot.domain.entities.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
    
}
