package com.dplay.dplayer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "genres")
@Getter
@Setter
@ToString
public class GenreEntity {
    @Id
    private String id;
    private String genreName;
    @CreatedDate
    private LocalDateTime insertTimestamp;
    @LastModifiedDate
    private LocalDateTime updateTimestamp;

    public GenreEntity(String genreName) {
        super();
        this.genreName = genreName;
    }
}
