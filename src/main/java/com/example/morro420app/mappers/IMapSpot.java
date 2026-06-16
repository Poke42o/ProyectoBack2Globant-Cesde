package com.example.morro420app.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.morro420app.dtos.SpotDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.Spot;

@Mapper(componentModel = "spring")
public interface IMapSpot {

    IMapSpot INSTANCE = Mappers.getMapper(IMapSpot.class);
    SpotDto convert_model_to_dto (Spot spot);
    List<UserDto> convert_list_model_spot_to_dto (List<Spot>list);

}
