package com.dplay.dplayer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenreFieldsEnum {
    GENRE_NAME("genreName"),
    INSERT_TIME_STAMP("insertTimestamp"),
    UPDATE_TIME_STAMP("updateTimestamp");

    private final String databaseField;

}
