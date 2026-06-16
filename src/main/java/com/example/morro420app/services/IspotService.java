package com.example.morro420app.services;

import java.util.List;
import java.util.UUID;

import com.example.morro420app.dtos.SpotDto;
import com.example.morro420app.models.Spot;

public interface IspotService {

    SpotDto saveUserInBD (Spot data);

    SpotDto modifyUserInBD (Spot data, UUID id);

    List<SpotDto> searchUserInBD ();

    void deleteUserInBD (UUID id);

}
