package com.riwi.simulacro_SpringBoot.api.dto.request;

import java.time.LocalDate;

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
public class SubmissionRequest {

    @NotBlank(message = "El contenido es obligatorio")
    @Size(min= 1)
    private String content;
    @NotBlank(message = "La fecha de la presentacion es obligatoria")
    private LocalDate submission_date;  //Fecha dinal para el entregable
    @NotNull(message = "El grado es obligatorio")
    private Double grade;
    @NotNull(message = "El id del usuario es obligatorio")
    @Size(min= 1, message = "El id debe de ser mayor a cero")
    private Long user_id; 
    @NotNull(message = "El id de la asignación es obligatorio")
    @Size(min= 1, message = "El id debe de ser mayor a cero")
    private Long assignment_id; 

}
