package com.dplay.dplayer.service.serviceimpl;

import com.dplay.dplayer.dto.WebSeriesDTO;
import com.dplay.dplayer.mapper.WebSeriesMapper;
import com.dplay.dplayer.repository.WebSeriesRepository;
import com.dplay.dplayer.service.WebSeriesService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WebSeriesServiceImpl implements WebSeriesService {

    @Setter(onMethod_={@Autowired})
    private WebSeriesMapper webSeriesMapper;

    @Setter(onMethod_={@Autowired})
    private WebSeriesRepository webSeriesRepository;

    @Override
    public ResponseEntity<String> addWebSeriesDetails(WebSeriesDTO webSeriesDTO) {
        log.info("Web Series Details Received: {}", webSeriesDTO);
        return null;
    }

    @Override
    public Page<WebSeriesDTO> getAllWebSeries(Pageable page) {
        return null;
    }

    @Override
    public WebSeriesDTO getWebSeries(String id) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateWebSeries(String id, WebSeriesDTO webSeriesDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteWebSeries(String id) {
        return null;
    }
}
