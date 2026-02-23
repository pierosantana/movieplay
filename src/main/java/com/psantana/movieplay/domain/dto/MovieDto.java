package com.psantana.movieplay.domain.dto;

import com.psantana.movieplay.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean status
) {
}
