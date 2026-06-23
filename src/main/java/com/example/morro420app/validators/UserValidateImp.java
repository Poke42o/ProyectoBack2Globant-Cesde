package com.example.morro420app.validators;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.User;
import com.example.morro420app.repositories.IUserRepository;

@Component
public class UserValidateImp implements IUserValidator {
    
    private final IUserRepository userRepository;

    public UserValidateImp (IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateNewUser(User data) {
        validateRepeatEmail(data.getEmail());
        validateNameEmpty(data.getNames());
        validatePasswordLength(data.getPassword());
    }

    @Override
    public void validateDataModify(User data) {
        validateNameEmpty(data.getNames());
     
    }

    //Reglas de validacion individuales
    public void validateRepeatEmail(String email){
        if(userRepository.findByEmail(email).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "A user with the entered email address already exists."
            );

        }
    }
    public void validateNameEmpty(String names){
        if(names.isEmpty() || names.isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Name is required, please enter it"
            );
        }
    }
    public void validatePasswordLength(String password){
        if(password.length()<6){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid password, please check it"
            );

        }
}

}
