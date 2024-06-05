package com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services;

import com.riwi.simulacro_SpringBoot.api.dto.request.AssignmentRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.AssignmentBasicResponse;

public interface IAssignmentsService extends CrudService<AssignmentRequest, AssignmentBasicResponse, Long>{
    
}
