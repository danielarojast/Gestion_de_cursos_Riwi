package com.riwi.simulacro_SpringBoot.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseBasicResponse {
    
    private Long  id; 
    private String course_name;
    private String description; 
    private UserBasicResponse userInstructor;
}
