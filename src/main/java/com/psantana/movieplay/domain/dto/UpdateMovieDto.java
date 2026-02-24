package com.psantana.movieplay.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "The title is required")
        String title,
        @PastOrPresent(message = "The release date must be earlier than the current date")
        LocalDate releaseDate,
        @Min(value = 0, message = "The rating cannot be less than 0")
        @Max(value = 5, message = "The rating cannot be higher than 5")
        Double rating
) {
}
