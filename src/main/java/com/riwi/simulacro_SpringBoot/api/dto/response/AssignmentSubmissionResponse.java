package com.riwi.simulacro_SpringBoot.api.dto.response;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentSubmissionResponse extends AssignmentBasicResponse{
    private List<SubmissionBasicResponse> submissions;
}