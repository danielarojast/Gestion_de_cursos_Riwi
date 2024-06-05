package com.riwi.simulacro_SpringBoot.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonBasicResponse {
    private Long id;
    private String lesson_title;
    private String content;

    private CourseBasicResponse courses;
}
