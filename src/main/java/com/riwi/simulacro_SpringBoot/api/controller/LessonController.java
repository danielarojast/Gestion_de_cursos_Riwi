package com.riwi.simulacro_SpringBoot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.ILessonService;
import com.riwi.simulacro_SpringBoot.api.dto.request.LessonRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.LessonBasicResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lesson")
@Tag(name="Lessons")
public class LessonController {
    @Autowired
    private final ILessonService lessonService;
    
    /***** INSERT ****/
    @PostMapping
    public ResponseEntity<LessonBasicResponse> insert(
            @Validated @RequestBody LessonRequest request) {
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    /***** GET ALL ****/
    @GetMapping
    public ResponseEntity<Page<LessonBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(this.lessonService.getAll(page-1, size));
    }


    /***** GET BY ID ****/
    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonBasicResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.get(id));
    }

    /***** UPDATE ****/
    @PutMapping(path = "/{id}")
    public ResponseEntity<LessonBasicResponse> update(
            @Validated @RequestBody LessonRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.update(request, id));
    }

    /***** DELETE ****/
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.lessonService.dalete(id);
        return ResponseEntity.noContent().build();
    }

}
