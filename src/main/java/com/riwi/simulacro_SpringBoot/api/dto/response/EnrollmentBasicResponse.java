package com.riwi.simulacro_SpringBoot.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentBasicResponse {
    private Long id;
    private LocalDate enrollment_date;

    private UserBasicResponse users;
    private CourseBasicResponse courses; 
}
