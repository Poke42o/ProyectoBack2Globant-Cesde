package com.example.morro420app.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.morro420app.dtos.BookingDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.Booking;

@Mapper(componentModel = "spring")
public interface IMapBooking {

    IMapBooking INSTANCE = Mappers.getMapper(IMapBooking.class);
    BookingDto convert_model_to_dto (Booking booking);
    List<UserDto> convert_list_model_to_dto (List<Booking>list);
}
