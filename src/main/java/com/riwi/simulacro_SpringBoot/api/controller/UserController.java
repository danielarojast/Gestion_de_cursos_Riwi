package com.riwi.simulacro_SpringBoot.api.controller;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.IUserService;
import com.riwi.simulacro_SpringBoot.api.dto.request.UserRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.UserBasicResponse;
import com.riwi.simulacro_SpringBoot.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
@Tag(name="Users")
public class UserController {
    private final IUserService userService; 
    
    /****INSERT*** */
    @Operation(
        summary= "Crear usuarios",
        description= "Crar un nuevo usuario, debe de ingresar: userName, password, email, full_name y Role (ESTUDIANTE, PROFESOR)"
    )
    @PostMapping
    public ResponseEntity<UserBasicResponse> insert(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }

    /***** GET ALL ****/
    @Operation(
    summary = "Listar todos los Usuarios",
    description = "Se listan todos los usurios con sus atributos"
   )
    @GetMapping
    public ResponseEntity<Page<UserBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

    /***** GET BY ID****/
    //@ApiResponse es la notacion para el error cuando no esta el id (es para la documentacion).
   @Operation(
    summary = "Buscar por Id",
    description = "Se busca ususario por id, debe de ingresar Id tipo entero"
   )
    @ApiResponse(
		responseCode= "400",
		description= "El id no es valido",
		content= {@Content(
			mediaType = "application/json",
			schema=@Schema(implementation = ErrorResponse.class)
            )
        }
	)
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserBasicResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    /*--- UPDATE ---*/
    @Operation(
    summary = "Actualizar usuario",
    description = "debe de ingresar Id de el usuario que desea actualizar"
   )
    @ApiResponse(
		responseCode= "400",
		description= "El id no es valido",
		content= {@Content(
			mediaType = "application/json",
			schema=@Schema(implementation = ErrorResponse.class)
            )
        }
	)
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserBasicResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.update(request, id));
    }

    
    /*--- DELETE ---*/
    @Operation(
    summary = "Eliminar",
    description = "Debe de ingresar Id del usuario que desea eliminar."
   )
    @ApiResponse(
		responseCode= "400",
		description= "El id no es valido",
		content= {@Content(
			mediaType = "application/json",
			schema=@Schema(implementation = ErrorResponse.class)
            )
        }
	)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.dalete(id);
        return ResponseEntity.noContent().build();
    }
}
