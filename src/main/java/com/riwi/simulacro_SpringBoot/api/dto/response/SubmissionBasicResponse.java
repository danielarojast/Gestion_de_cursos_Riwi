package com.riwi.simulacro_SpringBoot.api.dto.response;

import java.time.LocalDate;

import com.riwi.simulacro_SpringBoot.domain.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class SubmissionBasicResponse {
    private Long id;
    private String content;
    private LocalDate submission_date;
    private Double grade;
    private Users users;
    private AssignmentBasicResponse assignments;
}
