package com.example.morro420app.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateUserDto {


    @NotBlank(message = "The name cannot be empty")
    @Size(max = 100, message = "The names field cannot exceed 100 characters")
    private String names;

    @NotBlank(message = "The email cannot be empty")
    @Email(message = "The email must be valid")
    @Size(max = 100, message = "The email field cannot exceed 100 characters")
    private String email;

    @NotNull(message = "Must have a role")
    private String role;
    
}
