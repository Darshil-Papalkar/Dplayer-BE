package com.dplay.dplayer.service.serviceimpl;

import com.dplay.dplayer.dto.GenreDTO;
import com.dplay.dplayer.entity.GenreEntity;
import com.dplay.dplayer.mapper.GenreMapper;
import com.dplay.dplayer.repository.GenreRepository;
import com.dplay.dplayer.service.GenreService;
import com.dplay.dplayer.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreMapper genreMapper;
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreMapper genreMapper, GenreRepository genreRepository) {
        this.genreMapper = genreMapper;
        this.genreRepository = genreRepository;
    }

    @Override
    public ResponseEntity<String> addGenreDetails(List<GenreDTO> genreDTOList) {
        log.info("Received Genre List: {}", genreDTOList);
        if(genreDTOList.isEmpty()) {
            return new ResponseEntity<>("Genre Cannot be Empty", null, HttpStatus.BAD_REQUEST);
        }
        List<GenreEntity> genreEntityList = new ArrayList<>();
        genreDTOList.forEach(genre -> {
            GenreEntity genreEntity = CommonUtils.capitalizeAllStrings(genreMapper.genreDTOToGenreEntity(genre));
            genreEntityList.add(genreEntity);
        });
        log.info("Saving Genre List: {}", genreEntityList);
        List<GenreEntity> genreEntitiesSaved = genreRepository.saveAll(genreEntityList);
        log.info("Successfully Saved Genre List: {}", genreEntitiesSaved);
        return new ResponseEntity<>("Successfully Added Genres", null, HttpStatus.CREATED);
    }

    @Override
    public Page<GenreDTO> getAllGenres(Pageable page) {
        Page<GenreEntity> genreEntities = genreRepository.findAll(page);
        log.info("Fetched genre : {}", genreEntities.getSize());
        return genreEntities.map(genreMapper::genreEntityToGenreDTO);
    }

    @Override
    public GenreDTO getGenre(String id) {
        Optional<GenreEntity> genreEntityOptional = genreRepository.findById(id);
        return genreEntityOptional.map(genreMapper::genreEntityToGenreDTO).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateGenre(String id, GenreDTO genreDTO) {
        GenreDTO genre = this.getGenre(id);
        if(genre != null) {
            genre.setGenreName(genreDTO.getGenreName());
            GenreEntity genreEntity = CommonUtils.capitalizeAllStrings(genreMapper.genreDTOToGenreEntity(genre));
            genreRepository.save(genreEntity);
            return ResponseEntity.ok("Successfully updated Genre");
        }
        return new ResponseEntity<>("Genre Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteGenre(String id) {
        GenreDTO genre = this.getGenre(id);
        if(genre != null) {
            genreRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted theme: '" + genre.getGenreName() + "'");
        }
        return new ResponseEntity<>("Theme Not Found", HttpStatus.NOT_FOUND);
    }
}
