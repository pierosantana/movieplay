package com.psantana.movieplay.persistence.mapper;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.domain.dto.UpdateMovieDto;
import com.psantana.movieplay.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StatusMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source ="duracion"  , target ="duration" )
    @Mapping(source ="genero"  , target ="genre", qualifiedByName = "stringToGenre")
    @Mapping(source ="fechaEstreno" , target ="releaseDate" )
    @Mapping(source ="clasificacion", target = "rating")
    @Mapping(source ="estado", target = "status", qualifiedByName = "stringToStatus")
    MovieDto toDto (MovieEntity entity);

    List<MovieDto> toDto (Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source ="genre"  , target ="genero", qualifiedByName = "genreToString")
    @Mapping(source = "status", target = "estado", qualifiedByName = "statusToString")
    MovieEntity toEntity(MovieDto dto);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source ="releaseDate", target = "fechaEstreno")
    @Mapping(source = "rating", target = "clasificacion")
    void updateEntityFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);

}
