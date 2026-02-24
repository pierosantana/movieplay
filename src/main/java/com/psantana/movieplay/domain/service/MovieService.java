package com.psantana.movieplay.domain.service;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.dto.UpdateMovieDto;
import com.psantana.movieplay.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas que exitan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return movieRepository.getAll();
    }

    public MovieDto getById(Long id){
        return movieRepository.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));
    }

    public MovieDto save(MovieDto movieDto) {
        return movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        return movieRepository.update(id, updateMovieDto)
                .orElseThrow(()-> new EntityNotFoundException("Movie not found"));
    }

    public boolean delete(Long id) {
        return movieRepository.delete(id);
    }
}
