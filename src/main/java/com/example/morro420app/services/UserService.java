package com.example.morro420app.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.morro420app.models.User;
import com.example.morro420app.repositories.IUserRepository;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository userRepository;

    public boolean saveUserBD (User data){
        //Validar datos y verificar que cumplan
        //guardar datos
        return false;
    }

    public boolean modifyUserBD (User data, UUID id){
        //validar datos y verificar que cumplan
        //modificar los datos en BD
    
        return false;
    }

    public boolean deleteUserDB (UUID id){
        //buscar y validar si el ID existe
        //Eliminar registro
        return false;
    }

    public boolean searchUserBD (){
        //Dependiedo del parametro de busqueda debo implementar validaciones
        //devuelvo los usuarios o usuario que encuentre en BD
        return false;
    }
}
