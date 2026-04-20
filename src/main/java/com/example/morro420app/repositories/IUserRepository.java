package com.example.morro420app.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.morro420app.models.User;
import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository <User, UUID>{

    Optional<User>findByEmail(String email);
}
