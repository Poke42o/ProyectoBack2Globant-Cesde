package com.example.morro420app.validators;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Spot;

@Component
public class SpotValidateImp implements ISpotValidator {

    @Override
    public void validateNewSpot(Spot data) {
        validateNameNotBlank(data.getName());
        validateDescriptionNotBlank(data.getDescription());
        validatePhotoNotBlank(data.getPhoto());
        validateCapacity(data.getCapacity());
    }

    @Override
    public void validateDataModify(Spot data) {
        validateNameNotBlank(data.getName());
        validateDescriptionNotBlank(data.getDescription());
        validatePhotoNotBlank(data.getPhoto());
        validateCapacity(data.getCapacity());
    }

    private void validateNameNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The spot name cannot be empty."
            );
        }
    }

    private void validateDescriptionNotBlank(String description) {
        if (description == null || description.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The spot description cannot be empty."
            );
        }
    }

    private void validatePhotoNotBlank(String photo) {
        if (photo == null || photo.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The spot photo cannot be empty."
            );
        }
    }

    private void validateCapacity(Integer capacity) {
        if (capacity == null || capacity <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The spot capacity must be greater than zero."
            );
        }
    }
}
