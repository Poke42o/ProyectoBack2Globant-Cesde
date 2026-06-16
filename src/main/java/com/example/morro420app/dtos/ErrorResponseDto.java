package com.example.morro420app.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorResponseDto {

    private String message;
   
    private List <String> details;

    private Boolean succes;


    
}
