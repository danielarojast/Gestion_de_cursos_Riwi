package com.riwi.simulacro_SpringBoot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.simulacro_SpringBoot.domain.entities.Lessons;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Long> {
    
}
