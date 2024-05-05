package com.dplay.dplayer.dto;

import com.dplay.dplayer.view.Episode;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WebSeriesDTO {
    private String id;
    private String webSeriesName;
    private String webSeriesDescription;
    private List<Episode> episodes;
    private Double rating;
    private int played;
    private LocalDateTime insertTimestamp;
    private LocalDateTime updateTimestamp;
}
