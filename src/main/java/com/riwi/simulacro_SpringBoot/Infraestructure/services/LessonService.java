package com.riwi.simulacro_SpringBoot.Infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.ILessonService;
import com.riwi.simulacro_SpringBoot.api.dto.request.LessonRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.LessonBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.UserBasicResponse;
import com.riwi.simulacro_SpringBoot.domain.entities.Courses;
import com.riwi.simulacro_SpringBoot.domain.entities.Lessons;
import com.riwi.simulacro_SpringBoot.domain.repository.CoursesRepository;
import com.riwi.simulacro_SpringBoot.domain.repository.LessonsRepository;
import com.riwi.simulacro_SpringBoot.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{
    
    @Autowired
    private final LessonsRepository lessonsRepository;
    @Autowired
    private final CoursesRepository coursesRepository;

    @Override
    public LessonBasicResponse create(LessonRequest request) {
        Lessons entity = this.requestToEntity(request);
        return this.entityToBasciResp(this.lessonsRepository.save(entity));
    }

    @Override
    public LessonBasicResponse get(Long id) {
        return this.entityToBasciResp(this.find(id));
    }

    @Override
    public LessonBasicResponse update(LessonRequest request, Long id) {
        Lessons entity = this.find(id);
        entity= this.requestToEntity(request);
        entity.setId(id);

        return this.entityToBasciResp(this.lessonsRepository.save(entity));
    }

    @Override
    public void dalete(Long id) {
        this.lessonsRepository.delete(this.find(id));
    }

    @Override
    public Page<LessonBasicResponse> getAll(int page, int size) {
       if(page <0 )
            page = 0;
        
        PageRequest pagination = PageRequest.of(page, size);
        return this.lessonsRepository.findAll(pagination)
                .map(this::entityToBasciResp);
    }

    /*+*********************************************************************** */

    private Lessons requestToEntity(LessonRequest request){
        return Lessons.builder()
                    .lesson_title(request.getLesson_title())
                    .content(request.getContent())
                    .courses(this.findCourse(request.getCourse_id()))
                    .build();
    }

    private LessonBasicResponse entityToBasciResp(Lessons entity){
        
        UserBasicResponse user = UserBasicResponse.builder()
                        .id(entity.getCourses().getInstructor().getId())
                        .email(entity.getCourses().getInstructor().getEmail())
                        .full_name(entity.getCourses().getInstructor().getFull_name())
                        .role(entity.getCourses().getInstructor().getRole())
                        .build();

        CourseBasicResponse course = CourseBasicResponse.builder()
                        .id(entity.getCourses().getId())
                        .course_name(entity.getCourses().getCourse_name())
                        .description(entity.getCourses().getDescription())
                        .userInstructor(user)
                        .build();

        return LessonBasicResponse.builder()
                        .id(entity.getId())
                        .lesson_title(entity.getLesson_title())
                        .content(entity.getContent())
                        .courses(course)
                        .build();

    }


    private Lessons find(Long id){
        return this.lessonsRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("No hay lecciones por el id suministrado"));
    }

    private Courses findCourse(Long id){
        return this.coursesRepository.findById(id)
                                .orElseThrow(() -> new BadRequestException("No hay cursos por el id suministrado"));
    }
    
}
