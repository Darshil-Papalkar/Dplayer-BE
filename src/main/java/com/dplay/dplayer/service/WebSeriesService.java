package com.dplay.dplayer.service;

import com.dplay.dplayer.dto.ThemeDTO;
import com.dplay.dplayer.dto.WebSeriesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WebSeriesService {
    ResponseEntity<String> addWebSeriesDetails(WebSeriesDTO webSeriesDTOList);

    Page<WebSeriesDTO> getAllWebSeries(Pageable page);

    WebSeriesDTO getWebSeries(String id);

    ResponseEntity<String> updateWebSeries(String id, WebSeriesDTO webSeriesDTO);

    ResponseEntity<String> deleteWebSeries(String id);
}
