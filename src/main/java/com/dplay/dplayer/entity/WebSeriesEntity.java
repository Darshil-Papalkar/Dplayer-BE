package com.dplay.dplayer.entity;

import com.dplay.dplayer.view.Episode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "webseries")
@Getter
@Setter
@ToString
public class WebSeriesEntity {
    @Id
    private String id;
    private String webSeriesName;
    private String webSeriesDescription;
    private List<Episode> episodes;
    private Double rating;
    private int played;
    @CreatedDate
    private LocalDateTime insertTimestamp;
    @LastModifiedDate
    private LocalDateTime updateTimestamp;
}
