package com.riwi.simulacro_SpringBoot.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentBasicResponse {
    private Long id;
    private String assignment_title;
    private String description;
    private LocalDate due_date;
    
    private LessonBasicResponse lessons;
}
