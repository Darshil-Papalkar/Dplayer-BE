package com.dplay.dplayer.mapper;

import com.dplay.dplayer.dto.WebSeriesDTO;
import com.dplay.dplayer.entity.WebSeriesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WebSeriesMapper {
    WebSeriesEntity webSeriesDTOToWebSeriesEntity(WebSeriesDTO webSeriesDTO);
    WebSeriesDTO webSeriesEntityToWebSeriesDTO(WebSeriesEntity webSeriesEntity);
}
