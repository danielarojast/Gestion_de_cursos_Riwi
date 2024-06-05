package com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services;

import com.riwi.simulacro_SpringBoot.api.dto.request.CourseRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseLessionReponse;

public interface ICourseService extends CrudService<CourseRequest, CourseBasicResponse, Long>{
    CourseLessionReponse getlessonsByCourseId(Long courseId); 
}
