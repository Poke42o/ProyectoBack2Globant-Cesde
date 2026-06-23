package com.example.morro420app.validators;

import com.example.morro420app.models.User;

public interface IUserValidator {

    
     void validateNewUser (User data);
     void validateDataModify (User data);
}
