package com.example.morro420app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Spot;
import com.example.morro420app.repositories.ISpotRepository;
import com.example.morro420app.validators.ISpotValidator;

@Service
public class SpotServiceImp implements IspotService {

    private final ISpotRepository spotRepository;
    private final ISpotValidator spotValidator;

    public SpotServiceImp(ISpotRepository spotRepository, ISpotValidator spotValidator) {
        this.spotRepository = spotRepository;
        this.spotValidator = spotValidator;
    }

    @Override
    public Spot saveSpotBD(Spot data) {
        this.spotValidator.validateNewSpot(data);
        return this.spotRepository.save(data);
    }

    @Override
    public Spot modifySpotBD(Spot data, UUID id) {
        Optional<Spot> spotToSearch = this.spotRepository.findById(id);
        if (spotToSearch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Spot not found");
        }

        Spot spotFound = spotToSearch.get();
        this.spotValidator.validateDataModify(data);
        spotFound.setName(data.getName());
        spotFound.setDescription(data.getDescription());
        spotFound.setPhoto(data.getPhoto());
        spotFound.setCapacity(data.getCapacity());
        return this.spotRepository.save(spotFound);
    }

    @Override
    public boolean deleteSpotDB(UUID id) {
        if (!this.spotRepository.existsById(id)) {
            return false;
        }
        this.spotRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Spot> searchSpotBD() {
        return this.spotRepository.findAll();
    }
}
