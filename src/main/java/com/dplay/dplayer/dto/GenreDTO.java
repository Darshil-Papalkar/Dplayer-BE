package com.dplay.dplayer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GenreDTO {
    private String id;
    private String genreName;
    private LocalDateTime insertTimestamp;
    private LocalDateTime updateTimestamp;
}
