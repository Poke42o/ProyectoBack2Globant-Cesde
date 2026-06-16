package com.example.morro420app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.dtos.CreateUserDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.mappers.IMapUser;
import com.example.morro420app.models.User;
import com.example.morro420app.repositories.IUserRepository;

@Service
public class UserServiceImp implements IUserService{

    //1. Llamar a los helpers o dependencias que necesito

    private final IMapUser userMap;
    private final IUserRepository userRepository;

    public UserServiceImp(IMapUser userMap, IUserRepository userRepository) {
        this.userMap = userMap;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUserInBD(User data) {
        // TODO Auto-generated method stub

        User saveUser=this.userRepository.save(data);
        return this.userMap.convert_model_to_dto(saveUser);

    }

    @Override
    public UserDto modifyUserInBD(User data, UUID id) {
        // TODO Auto-generated method stub

        //buscando que el usuario exista en BD
        Optional<User> userToSearch=this.userRepository.findById(id);
        if (userToSearch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User dont found");
            
        }

        User userFound=userToSearch.get();
        //Incluir validaciones (proximamente) y validar los datos nuevos
        //Aplicar cambios
        userFound.setNames(data.getNames());
        User userModify=this.userRepository.save(userFound);

        //Convierto la respuesta a DTO
        return this.userMap.convert_model_to_dto(userModify);
    }

    @Override
    public List<UserDto> searchUserInBD() {

        List<User> usersFound=this.userRepository.findAll();
        return this.userMap.convert_list_model_to_dto(usersFound);
    }

    @Override
    public void deleteUserInBD(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserInBD'");
    }

    @Override
    public UserDto createUserInBD(CreateUserDto createUserDto) {
        if (createUserDto == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User data cannot be null");
        }

        if (this.userRepository.findByEmail(createUserDto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        User user = this.userMap.convert_dto_to_model(createUserDto);

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            user.setPassword(UUID.randomUUID().toString());
        }

        User savedUser = this.userRepository.save(user);
        return this.userMap.convert_model_to_dto(savedUser);
    }
    
}
