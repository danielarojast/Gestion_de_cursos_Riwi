package com.riwi.simulacro_SpringBoot.api.dto.request;

import jakarta.validation.constraints.Min;
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
public class CourseRequest {
    @NotBlank(message = "El nombre del curso es requerido")
    @Size(min=4, max= 100, message = "El nombre debe de tener por lo menos 4 digitos")
    private String course_name;
    @NotBlank
    private String description; 

    @NotNull(message = "El id del usuario es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero ")
    private Long instructor_id;
}
