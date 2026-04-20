package com.example.morro420app.services;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.User;
import com.example.morro420app.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User saveUserBD(User data) {
        if (userRepository.findByEmail(data.getEmail()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This email is used");

        }
        if (data.getNames().isEmpty() || data.getNames().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The name cannot be empty");

        }
        if (data.getPassword().length() < 6) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The password must be at least 6 characters long");

        }

        // Si paso la zona de validaciones procedo a preparar la receta (ejecuto la
        // query que se necesite)
        return this.userRepository.save(data);
        

    }

    public User modifyUserBD(User data, UUID id) {
        // validar datos y verificar que cumplan
        // modificar los datos en BD

                //1. buscar si el usuario existe en BD
        Optional<User> user_to_search=this.userRepository.findById(id);
        if (user_to_search.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "The user dont exist in DB"
            );
            
        }
        User user_found=user_to_search.get();

        //2. validar informacion nueva que llega
    if(data.getNames().isEmpty() || data.getNames().isBlank()){
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "review the name"
        );
    }

        //3. ejecutar el nuevo guardado y retornar
        user_found.setNames(data.getNames());
        
        return this.userRepository.save(user_found);
    }

    public boolean deleteUserDB(UUID id) {
        // buscar y validar si el ID existe
        if (!this.userRepository.existsById(id)) {
            return false;
        }
        // Eliminar registro
        this.userRepository.deleteById(id);
        return true;
    }

    public List<User> searchUserBD() {
        // Dependiedo del parametro de busqueda debo implementar validaciones
        // devuelvo los usuarios o usuario que encuentre en BD
        List<User> usersFound = this.userRepository.findAll();
        return usersFound;
    }
}
