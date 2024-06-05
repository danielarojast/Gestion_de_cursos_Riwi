package com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services;

import com.riwi.simulacro_SpringBoot.api.dto.request.UserRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.UserBasicResponse;

public interface IUserService extends CrudService<UserRequest, UserBasicResponse, Long>{
    
}
