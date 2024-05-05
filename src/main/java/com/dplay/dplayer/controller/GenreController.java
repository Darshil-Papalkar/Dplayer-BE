package com.dplay.dplayer.controller;

import com.dplay.dplayer.controller.common.GenericController;
import com.dplay.dplayer.dto.GenreDTO;
import com.dplay.dplayer.enums.GenreFieldsEnum;
import com.dplay.dplayer.service.serviceimpl.GenreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class GenreController implements GenericController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/admin/addGenre")
    public ResponseEntity<String> addGenre(@RequestBody GenreDTO genres) {
        List<GenreDTO> genreList = Arrays.stream(genres.getGenreName().split(",")).map(String::strip).filter(genre -> !genre.isEmpty()).map(genre -> {
            GenreDTO genreDTO = new GenreDTO();
            genreDTO.setGenreName(genre);
            return genreDTO;
        }).toList();
        return genreService.addGenreDetails(genreList);
    }

    @PutMapping("/admin/editGenre/{id}")
    public ResponseEntity<String> updateGenre(@PathVariable String id, @RequestBody GenreDTO genre) {
        return genreService.updateGenre(id, genre);
    }

    @GetMapping("/admin/getAllGenres")
    public Page<GenreDTO> getGenre(@RequestParam(defaultValue = "${default.pageNo}") int page,
                                   @RequestParam(defaultValue = "${default.pageSize}") int size,
                                   @RequestParam(defaultValue = "${default.entity}") GenreFieldsEnum sortField,
                                   @RequestParam(defaultValue = "${default.direction}") Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortField.getDatabaseField());
        Pageable pageable = PageRequest.of(page, size, sort);
        log.info("Created pageable: {} and sorting: {}", pageable, sort);
        return genreService.getAllGenres(pageable);
    }

    @GetMapping("/admin/getGenre/{id}")
    public ResponseEntity<GenreDTO> getGenre(@PathVariable String id) {
        GenreDTO genre = genreService.getGenre(id);
        if (genre != null) return ResponseEntity.ok(genre);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admin/deleteGenre/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable String id) {
        return genreService.deleteGenre(id);
    }
}
