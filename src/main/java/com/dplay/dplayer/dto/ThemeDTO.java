package com.dplay.dplayer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ThemeDTO {
    private String id;
    private String themeName;
    private LocalDateTime insertTimestamp;
    private LocalDateTime updateTimestamp;
}
