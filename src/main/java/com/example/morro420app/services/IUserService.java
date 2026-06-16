package com.example.morro420app.services;

import java.util.List;
import java.util.UUID;

import com.example.morro420app.dtos.CreateUserDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.User;

public interface IUserService {
    //Contrato que describe que se puede hacer en el servicio

    UserDto createUserInBD(CreateUserDto createUserDto);

    UserDto saveUserInBD (User data);

    UserDto modifyUserInBD (User data, UUID id);

    List<UserDto> searchUserInBD ();

    void deleteUserInBD (UUID id);

    

}
