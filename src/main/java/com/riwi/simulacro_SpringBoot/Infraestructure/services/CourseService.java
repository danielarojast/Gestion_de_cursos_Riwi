package com.riwi.simulacro_SpringBoot.Infraestructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.ICourseService;
import com.riwi.simulacro_SpringBoot.api.dto.request.CourseRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.CourseLessionReponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.LessonBasicResponse;
import com.riwi.simulacro_SpringBoot.api.dto.response.UserBasicResponse;
import com.riwi.simulacro_SpringBoot.domain.entities.Courses;
import com.riwi.simulacro_SpringBoot.domain.entities.Lessons;
import com.riwi.simulacro_SpringBoot.domain.entities.Users;
import com.riwi.simulacro_SpringBoot.domain.repository.CoursesRepository;
import com.riwi.simulacro_SpringBoot.domain.repository.UsersRepository;
import com.riwi.simulacro_SpringBoot.utils.enums.RoleUsers;
import com.riwi.simulacro_SpringBoot.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{
    
    
    @Autowired
    private final CoursesRepository coursesRepository;
    @Autowired
    private final UsersRepository usersRepository;

    @Override
    public CourseBasicResponse create(CourseRequest request) {
        
        Courses course = this.requestToEntity(request);
        // Validar si es profesor 
        if(course.getInstructor().getRole().equals(RoleUsers.PROFESOR)){
            return this.entityToResponse(this.coursesRepository.save(course));
        }else{
            throw new BadRequestException("Solo los profesores pueden crear cursos");
        }

    }

    @Override
    public CourseBasicResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public CourseBasicResponse update(CourseRequest request, Long id) {
        Courses entity = this.find(id);
        entity = requestToEntity(request);
        entity.setId(id);

        return entityToResponse(this.coursesRepository.save(entity));
    }

    @Override
    public void dalete(Long id) {
        this.coursesRepository.delete(this.find(id));
    }

    @Override
    public Page<CourseBasicResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination= PageRequest.of(page, size);

        return this.coursesRepository.findAll(pagination)
                            .map(this::entityToResponse);

    }

    @Override
    public CourseLessionReponse getlessonsByCourseId(Long id) {
        Courses entity = this.find(id);
        List<LessonBasicResponse> lessons = entity.getLessons()
                        .stream()
                        .map(this::entityToLessonBasciResp)
                        .collect(Collectors.toList());

        return CourseLessionReponse.builder()
                    .id(entity.getId())
                    .course_name(entity.getCourse_name())
                    .description(entity.getDescription())
                    .lessons(lessons)
                    .build();
    }

    /**************************************************************** */

     private CourseBasicResponse entityToResponse(Courses entity) {

        UserBasicResponse instructor = UserBasicResponse.builder()
            .id(entity.getInstructor().getId())
            .email(entity.getInstructor().getEmail())
            .full_name(entity.getInstructor().getFull_name())
            .role(entity.getInstructor().getRole())
            .build();

        return CourseBasicResponse.builder()
                .id(entity.getId())
                .course_name(entity.getCourse_name())
                .description(entity.getDescription())
                .userInstructor(instructor)
                .build();

    }

    private Courses requestToEntity(CourseRequest request) {

        return Courses.builder()
            .course_name(request.getCourse_name())
            .description(request.getDescription())
            .instructor(this.findUser(request.getInstructor_id()))
            .build();
    }

    private Courses find(Long id) {
        return this.coursesRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay citas con el id suministrado"));
    }

    private Users findUser(Long id){
        return this.usersRepository.findById(id)
                                .orElseThrow(() -> new BadRequestException("No hay usuarios con el id suministrado"));
    }

    private LessonBasicResponse entityToLessonBasciResp(Lessons entity){
        
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
    
}
