package com.example.morro420app.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.morro420app.dtos.CreateUserDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.User;

@Mapper(componentModel = "spring")
public interface IMapUser {
    
    IMapUser INSTANCE = Mappers.getMapper(IMapUser.class);
    UserDto convert_model_to_dto (User user);
    User convert_dto_to_model(CreateUserDto createUserDto);
    List<UserDto> convert_list_model_to_dto (List<User>list);
}
