package com.psantana.movieplay.domain.repository;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<MovieDto> getAll();
    Optional<MovieDto> getById(Long id);
    MovieDto save(MovieDto movieDto);
    Optional<MovieDto> update(Long id, UpdateMovieDto updateMovieDto);
    boolean delete(Long id);
}
