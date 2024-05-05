package com.dplay.dplayer.view;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class Episode {
    @Id
    private String id;
    private String episodeName;
    private String episodeDescription;
    private Double episodeLength;
    @CreatedDate
    private LocalDateTime insertTimestamp;
    @LastModifiedDate
    private LocalDateTime updateTimestamp;
}
