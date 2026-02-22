package com.psantana.movieplay.domain.repository;

import com.psantana.movieplay.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}
