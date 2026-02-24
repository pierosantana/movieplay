package com.psantana.movieplay.persistence;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.dto.UpdateMovieDto;
import com.psantana.movieplay.domain.exception.MovieAlreadyExistsException;
import com.psantana.movieplay.domain.repository.MovieRepository;
import com.psantana.movieplay.persistence.crud.CrudMovieEntity;
import com.psantana.movieplay.persistence.entity.MovieEntity;
import com.psantana.movieplay.persistence.mapper.MovieMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return movieMapper.toDto(crudMovieEntity.findAll());
    }

    @Override
    public Optional<MovieDto> getById(Long id) {
        return crudMovieEntity.findById(id)
                .map(movieMapper::toDto);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (crudMovieEntity.findMovieByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }
        MovieEntity movieEntity = movieMapper.toEntity(movieDto);
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));

    }

    @Override
    public Optional<MovieDto> update(Long id, UpdateMovieDto updateMovieDto) {
        return crudMovieEntity.findById(id)
                .map(movieEntity -> {
                    movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
                    return crudMovieEntity.save(movieEntity);
                }).map(movieMapper::toDto);
    }

    @Override
    public boolean delete(Long id) {
        if(!crudMovieEntity.existsById(id)) return false;
        crudMovieEntity.deleteById(id);
        return true;
    }

}
