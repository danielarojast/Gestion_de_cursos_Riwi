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
public class MessageRequest {
    @NotBlank(message = "El mensaje debe de tener un contenido")
    @Size(min = 1)
    private String message_content; 
    
    @NotNull(message = "Debe de ingresar el id del remitente ")
    @Size(min = 1, message = "El id debe de ser mayor que 1")
    private Long sender_id;

    @NotNull(message = "Debe de ingresar el id del receptor")
    @Size(min = 1, message = "El id debe de ser mayor que 1")
    private Long receiver_id; 

    @NotNull(message = "Debe de ingresar el id del curso")
    @Size(min = 1, message = "El id debe de ser mayor que 1")
    private  Long course_id;
}
