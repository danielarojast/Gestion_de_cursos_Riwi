package com.riwi.simulacro_SpringBoot.api.controller;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.ICourseService;
import com.riwi.simulacro_SpringBoot.api.dto.request.CourseRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseLessionReponse;
import com.riwi.simulacro_SpringBoot.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/course")
@Tag(name="Courses")
public class CourseController {
    private final ICourseService courseService;
    
    /***** INSERT ****/
    @Operation(
    summary = "Crear curso",
    description = "Para crearlo debe de ingresar  course_name, description y instructor_id.")
    @PostMapping
    public ResponseEntity<CourseBasicResponse> insert(
            @Validated @RequestBody CourseRequest request) {
        return ResponseEntity.ok(this.courseService.create(request));
    }

    /***** GET ALL ****/
    @Operation(
        summary = "Listtar cursos",
        description = "Lista todos los cursos")
    @GetMapping
    public ResponseEntity<Page<CourseBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.courseService.getAll(page - 1, size));
    }


    /***** GET BY ID ****/
    @Operation(
        summary = "Buscar curso por id",
        description = "Ingresa el id del curso que deseas buscar")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CourseBasicResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.get(id));
    }
    
    /***** UPDATE ****/
    @Operation(
        summary = "Actualizar curso",
        description = "Ingresa el id del curso que deseas actualizar")
    @PutMapping(path = "/{id}")
    public ResponseEntity<CourseBasicResponse> update(
            @Validated @RequestBody CourseRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.update(request, id));
    }

    /***** DELETE ****/
    @Operation(
        summary = "Eliminar curso",
        description = "Ingresa el id del curso que deseas eliminar")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.courseService.dalete(id);
        return ResponseEntity.noContent().build();
    }

    /**** LECCIONES POR ID DE CURSO */
    @Operation(
        summary = "Busca lecciones por curso",
        description = "Busca un curso especifico segun el id y lista todas las lecciones del curso.")
    @GetMapping(path = "/{id}/lessons")
    public ResponseEntity<CourseLessionReponse> getAll(@PathVariable Long id){
        return ResponseEntity.ok(this.courseService.getlessonsByCourseId(id));
    }
}
