package com.example.morro420app.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.morro420app.enums.TimeSlot;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {
    private UUID id;

    @NotNull(message = "the date field cannot be empty")
    private LocalDateTime date;

    @NotNull(message = "the time field cannot be empty")
    private TimeSlot time;
}
