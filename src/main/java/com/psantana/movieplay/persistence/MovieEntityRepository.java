package com.psantana.movieplay.persistence;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.repository.MovieRepository;
import com.psantana.movieplay.persistence.crud.CrudMovieEntity;
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
}
