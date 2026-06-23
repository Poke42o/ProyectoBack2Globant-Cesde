package com.example.morro420app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.morro420app.dtos.CreateUserDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.User;
import com.example.morro420app.services.IUserService;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUserInBD (@RequestBody CreateUserDto createUserDto) {
        UserDto responseApi = service.createUserInBD(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseApi);
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = service.searchUserInBD();
        return ResponseEntity.ok(users);
    }
        
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody User user) {
        UserDto userUpdated = service.modifyUserInBD(user, id);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        service.deleteUserInBD(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}