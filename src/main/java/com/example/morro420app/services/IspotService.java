package com.example.morro420app.services;

import java.util.List;
import java.util.UUID;

import com.example.morro420app.models.Spot;

public interface IspotService {

    Spot saveSpotBD(Spot data);

    Spot modifySpotBD(Spot data, UUID id);

    List<Spot> searchSpotBD();

    boolean deleteSpotDB(UUID id);

}
