package com.riwi.simulacro_SpringBoot.api.dto.request;

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
public class EnrollmentRequest {
    
    @NotNull(message = "El id del usuario es obligatorio")
    @Size(min=1, message= "El id debe de ser mayor o igual a uno")
    private Long user_id;

    @NotNull(message = "El id del usuario es obligatorio")
    @Size(min=1, message= "El id debe de ser mayor o igual a uno")
    private Long course_id;

}
