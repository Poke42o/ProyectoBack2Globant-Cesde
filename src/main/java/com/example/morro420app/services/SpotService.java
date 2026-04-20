package com.example.morro420app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Spot;
import com.example.morro420app.repositories.ISpotRepository;

@Service
public class SpotService {

    @Autowired
    private ISpotRepository spotRepository;

    public Spot saveSpotBD (Spot data){
        if (spotRepository.findById(data.getId()).isPresent()) {
    throw new ResponseStatusException(
        HttpStatus.CONFLICT,
        "This name of this spot is used"
    );
    
}
if (data.getNames().isEmpty()||data.getNames().isBlank()) {
    throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "The name cannot be empty"
    );
}
        return this.spotRepository.save(data);
    }

    public Spot modifySpotBD (Spot data, UUID id){
                //1. buscar si el usuario existe en BD
        Optional<Spot> spot_to_search=this.spotRepository.findById(id);
        if (spot_to_search.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "The spot dont exist in DB"
            );
            
        }
        Spot spot_found=spot_to_search.get();

        //2. validar informacion nueva que llega
    if(data.getNames().isEmpty() || data.getNames().isBlank()){
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "review the name"
        );
    }

        //3. ejecutar el nuevo guardado y retornar
        spot_found.setNames(data.getNames());
        
        return this.spotRepository.save(spot_found);
    }

    public boolean deleteSpotDB (UUID id){
        //1. verificar si el spot existe en BD
        if (!this.spotRepository.existsById(id)) {
            return false; // No existe, no se puede eliminar
        }
        //2. eliminar el spot
        this.spotRepository.deleteById(id);
        return true;
    }

    public List<Spot> searchSpotBD (){
                List<Spot> usersFound = this.spotRepository.findAll();
        return usersFound;
     
    }
    
}
