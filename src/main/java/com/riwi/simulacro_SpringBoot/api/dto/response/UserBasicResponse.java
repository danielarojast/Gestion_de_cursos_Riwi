package com.riwi.simulacro_SpringBoot.api.dto.response;

import com.riwi.simulacro_SpringBoot.utils.enums.RoleUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {
    private Long id;
    private String email; 
    private String full_name; 
    private RoleUsers role; 
}
