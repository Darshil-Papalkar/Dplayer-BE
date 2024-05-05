package com.dplay.dplayer.service;

import com.dplay.dplayer.dto.GenreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {
    ResponseEntity<String> addGenreDetails(List<GenreDTO> genreDTOList);

    Page<GenreDTO> getAllGenres(Pageable page);

    GenreDTO getGenre(String id);

    ResponseEntity<String> updateGenre(String id, GenreDTO genreDTO);

    ResponseEntity<String> deleteGenre(String id);
}
