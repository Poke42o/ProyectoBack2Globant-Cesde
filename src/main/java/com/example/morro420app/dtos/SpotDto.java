package com.example.morro420app.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpotDto {
    
    private UUID id;

    @NotBlank(message = "the name field cannot be empty")
    @Size(max = 100, message = "the name field cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "the description field cannot be empty")
    @Size(max = 200, message = "the description field cannot exceed 200 characters")
    private String description;

    @NotBlank(message = "the photo field cannot be empty")
    private String photo;

    @NotNull(message = "the capacity field cannot be empty")
    private Integer capacity;
}
