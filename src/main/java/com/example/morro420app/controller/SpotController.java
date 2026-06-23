package com.example.morro420app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.morro420app.models.Spot;
import com.example.morro420app.services.IspotService;

@RestController
@RequestMapping("/api/v1/spots")
public class SpotController {

    private final IspotService spotService;

    public SpotController(IspotService spotService) {
        this.spotService = spotService;
    }

 
    @PostMapping
    public ResponseEntity<Spot> createSpot(@RequestBody Spot spot) {
        Spot spotCreated = this.spotService.saveSpotBD(spot);
        return new ResponseEntity<>(spotCreated, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Spot>> getAllSpots() {
        List<Spot> spots = this.spotService.searchSpotBD();
        return new ResponseEntity<>(spots, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Spot> updateSpot(@PathVariable UUID id, @RequestBody Spot spot) {
        Spot spotUpdated = this.spotService.modifySpotBD(spot, id);
        return new ResponseEntity<>(spotUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpot(@PathVariable UUID id) {
        boolean deleted = this.spotService.deleteSpotDB(id);
        if (deleted) {
            return new ResponseEntity<>("Spot deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Spot not found", HttpStatus.NOT_FOUND);
        }
    }
}
