package com.riwi.simulacro_SpringBoot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {
    @NotBlank(message = "El titutlo es obligatorio")
    @Size(min= 1, max = 100)
    private String assignment_title;
    private String description;

    @NotNull(message = "El id de la lección es obligatorio")
    @Size(min= 1, message = "El id debe de ser mayor que 1")
    private Long lesson_id; 

}
