package com.riwi.simulacro_SpringBoot.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class MessageResponse {
    private Long  id; 
    private String message_content;
    private LocalDate sent_date;

    private UserBasicResponse userSender; 
    private UserBasicResponse userReceiver;
    private CourseBasicResponse courses;
}
