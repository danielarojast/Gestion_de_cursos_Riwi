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
public class LessonRequest {
    @NotBlank(message = "El titulo de la lección es obligatorio")
    @Size(min= 1, max = 100)
    private String lesson_title;
    @NotBlank(message = "El contenido de la leccion es obligatorio")
    @Size(min= 1)
    private String content;
    @NotNull(message = "El id del curso es obligatorio")
    private Long course_id; 
}
