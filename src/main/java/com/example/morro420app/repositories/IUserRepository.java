package com.example.morro420app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.morro420app.models.User;

@Repository
public interface IUserRepository extends JpaRepository <User, UUID>{
    
}
