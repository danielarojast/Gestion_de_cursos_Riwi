package com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services;

import com.riwi.simulacro_SpringBoot.api.dto.request.LessonRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.LessonBasicResponse;

public interface ILessonService extends CrudService<LessonRequest, LessonBasicResponse, Long> {
    
}
