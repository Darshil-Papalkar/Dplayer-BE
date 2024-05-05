package com.dplay.dplayer.mapper;

import com.dplay.dplayer.dto.GenreDTO;
import com.dplay.dplayer.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreEntity genreDTOToGenreEntity(GenreDTO genreDTO);
    GenreDTO genreEntityToGenreDTO(GenreEntity genreEntity);
}
