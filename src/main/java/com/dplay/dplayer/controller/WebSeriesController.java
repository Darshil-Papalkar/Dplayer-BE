package com.dplay.dplayer.controller;

import com.dplay.dplayer.controller.common.GenericController;
import com.dplay.dplayer.dto.WebSeriesDTO;
import com.dplay.dplayer.service.serviceimpl.WebSeriesServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class WebSeriesController implements GenericController {

    @Setter(onMethod_ = {@Autowired})
    private WebSeriesServiceImpl webSeriesService;

    @PostMapping(
            path = "/admin/webSeries/add",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> uploadWebSeries(@RequestParam("file") MultipartFile file, @RequestBody WebSeriesDTO webSeriesDTO) {
//        webSeriesService.addWebSeriesDetails();

        return ResponseEntity.ok("");
    }
}
