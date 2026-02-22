package com.psantana.movieplay.persistence.mapper;

import com.psantana.movieplay.domain.dto.MovieDto;
import com.psantana.movieplay.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source ="duracion"  , target ="duration" )
    @Mapping(source ="genero"  , target ="genre" )
    @Mapping(source ="fechaEstreno" , target ="releaseDate" )
    @Mapping(source ="clasificacion", target = "rating")
    MovieDto toDto (MovieEntity entity);

    List<MovieDto> toDto (Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    MovieEntity toEntity(MovieDto dto);

}
