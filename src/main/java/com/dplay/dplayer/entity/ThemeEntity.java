package com.dplay.dplayer.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "themes")
@Getter
@Setter
@ToString
public class ThemeEntity {
    @Id
    private String id;
    private String themeName;
    @CreatedDate
    private LocalDateTime insertTimestamp;
    @LastModifiedDate
    private LocalDateTime updateTimestamp;

    public ThemeEntity(String themeName) {
        super();
        this.themeName = themeName;
    }

}
