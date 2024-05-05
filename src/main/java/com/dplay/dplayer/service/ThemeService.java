package com.dplay.dplayer.service;

import com.dplay.dplayer.dto.ThemeDTO;
import com.dplay.dplayer.entity.ThemeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThemeService {

    ResponseEntity<String> addThemeDetails(List<ThemeDTO> themeDTOList);

    Page<ThemeDTO> getAllThemes(Pageable page);

    ThemeDTO getTheme(String id);

    ResponseEntity<String> updateTheme(String id, ThemeDTO themeDTO);

    ResponseEntity<String> deleteTheme(String id);
}
