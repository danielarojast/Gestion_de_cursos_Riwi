package com.riwi.simulacro_SpringBoot.api.dto.request;

import com.riwi.simulacro_SpringBoot.utils.enums.RoleUsers;

import jakarta.validation.constraints.Email;
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
public class UserRequest 
{
    @NotBlank(message = "El nombre de usuario es necesario")
    @Size(min = 4, max = 50)
    private String userName; 
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, max = 100)
    private String password;
    @Email
    @NotBlank(message = "El email es requerido")
    private String email;
    @NotBlank(message = "El nombre completo es requerido")
    @Size(min = 6, max = 100)
    private String full_name;
    @NotNull(message = "El rol es requerido")
    private RoleUsers role;
}
