package com.riwi.simulacro_SpringBoot.Infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services.IUserService;
import com.riwi.simulacro_SpringBoot.api.dto.request.UserRequest;
import com.riwi.simulacro_SpringBoot.api.dto.response.UserBasicResponse;
import com.riwi.simulacro_SpringBoot.domain.entities.Users;
import com.riwi.simulacro_SpringBoot.domain.repository.UsersRepository;
import com.riwi.simulacro_SpringBoot.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    
    @Autowired
    private final UsersRepository usersRepository;

    @Override
    public UserBasicResponse create(UserRequest request) {
        Users user = this.requestToEntity(request);
        System.out.println(user);
        return this.entityToResp(this.usersRepository.save(user));
    }

    @Override
    public UserBasicResponse get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public UserBasicResponse update(UserRequest request, Long id) {
        Users userUpdate = this.find(id);
        userUpdate = this.requestToEntity(request);
        userUpdate.setId(id);

        return this.entityToResp(this.usersRepository.save(userUpdate));

    }

    @Override
    public void dalete(Long id) {
        Users user = this.find(id);
        this.usersRepository.delete(user);
    }

    @Override
    public Page<UserBasicResponse> getAll(int page, int size) {
        if (page <0) 
        page= 0; 
        PageRequest pagination= null;

        return this.usersRepository.findAll(pagination)
                .map(this::entityToResp);

    }

    /*--------------------------------------------------------- */
    
    private UserBasicResponse entityToResp(Users user){
        return UserBasicResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .full_name(user.getFull_name())
            .role(user.getRole())
            .build();
    }

    private Users requestToEntity(UserRequest users){
        return Users.builder()
            .userName(users.getUserName())
            .password(users.getPassword())
            .email(users.getEmail())
            .full_name(users.getFull_name())
            .role(users.getRole())
            .build();
    }

    private Users find(Long id){

        return this.usersRepository.findById(id)
            .orElseThrow(() -> new BadRequestException("No hay usuarios con el id suministrado"));
    } 
    
    
}
