package com.example.morro420app.validators;

import com.example.morro420app.models.Spot;

public interface ISpotValidator {

    void validateNewSpot(Spot data);

    void validateDataModify(Spot data);
}
