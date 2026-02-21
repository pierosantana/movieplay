package com.psantana.movieplay.web.controller;

import com.psantana.movieplay.persistence.crud.CrudMovieEntity;
import com.psantana.movieplay.persistence.entity.MovieEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieEntity>> getMovies() {
        List<MovieEntity> movies = new ArrayList<>();
        crudMovieEntity.findAll()
                .forEach(movies::add);
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieEntity> getMovie(@PathVariable Long id) {
        return crudMovieEntity.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<MovieEntity> createMovie(@RequestBody MovieEntity movieEntity) {
        return new ResponseEntity<>(crudMovieEntity.save(movieEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (!crudMovieEntity.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
        crudMovieEntity.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 OK, sin cuerpo
    }

}
