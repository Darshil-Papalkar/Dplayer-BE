package com.dplay.dplayer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ThemeFieldsEnum {
    THEME_NAME("themeName"),
    INSERT_TIME_STAMP("insertTimestamp"),
    UPDATE_TIME_STAMP("updateTimestamp");

    private final String databaseField;

}
