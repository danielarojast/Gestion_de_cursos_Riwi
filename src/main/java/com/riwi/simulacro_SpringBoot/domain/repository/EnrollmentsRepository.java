package com.riwi.simulacro_SpringBoot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.simulacro_SpringBoot.domain.entities.Enrollments;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {
    
}
