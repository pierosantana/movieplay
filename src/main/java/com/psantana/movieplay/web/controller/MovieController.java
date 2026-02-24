package com.psantana.movieplay.web.controller;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.dto.SuggestRequestDto;
import com.psantana.movieplay.domain.dto.UpdateMovieDto;
import com.psantana.movieplay.domain.service.MoviePlayAiService;
import com.psantana.movieplay.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies of Movieplay")
public class MovieController {

    private final MovieService movieService;
    private final MoviePlayAiService moviePlayAiService;

    public MovieController(MovieService movieService, MoviePlayAiService moviePlayAiService) {
        this.movieService = movieService;
        this.moviePlayAiService = moviePlayAiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getMovies() {
        if (this.movieService.getAll().isEmpty() || this.movieService.getAll() == null) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by Id",
            description = "Return the movie with the id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie found"),
                    @ApiResponse(responseCode = "404", description = "Movie no found",content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Movie id",example = "9") @PathVariable Long id) {

            return ResponseEntity.ok(movieService.getById(id));

    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(moviePlayAiService.generateMovieSeggestion(suggestRequestDto.userPreferences()));
    }


    @PostMapping("/save")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieService.save(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(
            @RequestBody @Valid UpdateMovieDto updateMovieDto,
            @PathVariable Long id) {
            return ResponseEntity.ok(movieService.update(id, updateMovieDto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return movieService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
