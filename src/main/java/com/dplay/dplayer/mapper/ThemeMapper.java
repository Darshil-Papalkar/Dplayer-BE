package com.dplay.dplayer.mapper;

import com.dplay.dplayer.dto.ThemeDTO;
import com.dplay.dplayer.entity.ThemeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThemeMapper {
    ThemeEntity themeDTOToThemeEntity(ThemeDTO themeDTO);
    ThemeDTO themeEntityToThemeDTO(ThemeEntity themeEntity);
}
