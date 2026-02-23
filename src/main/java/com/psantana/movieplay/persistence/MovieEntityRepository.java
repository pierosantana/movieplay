package com.psantana.movieplay.persistence;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.repository.MovieRepository;
import com.psantana.movieplay.persistence.crud.CrudMovieEntity;
import com.psantana.movieplay.persistence.entity.MovieEntity;
import com.psantana.movieplay.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);
        return movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = movieMapper.toEntity(movieDto);
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));

    }


}
