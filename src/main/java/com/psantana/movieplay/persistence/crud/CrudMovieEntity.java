package com.psantana.movieplay.persistence.crud;

import com.psantana.movieplay.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findMovieByTitulo(String titulo);
}
