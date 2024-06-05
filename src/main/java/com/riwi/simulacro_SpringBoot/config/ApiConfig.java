package com.riwi.simulacro_SpringBoot.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
	info= @Info(title= "Gestion de cursos en Riwi",
			version="1.0",
			description ="Aplicacion para gestionar ususarios y cursoso de riwi") ) 
public class ApiConfig {
    
}
