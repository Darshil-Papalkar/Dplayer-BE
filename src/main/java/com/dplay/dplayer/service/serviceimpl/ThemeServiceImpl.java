package com.dplay.dplayer.service.serviceimpl;

import com.dplay.dplayer.dto.ThemeDTO;
import com.dplay.dplayer.entity.ThemeEntity;
import com.dplay.dplayer.mapper.ThemeMapper;
import com.dplay.dplayer.repository.ThemeRepository;
import com.dplay.dplayer.service.ThemeService;
import com.dplay.dplayer.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeMapper themeMapper;
    private final ThemeRepository themeRepository;

    @Autowired
    public ThemeServiceImpl(ThemeMapper themeMapper, ThemeRepository themeRepository) {
        this.themeMapper = themeMapper;
        this.themeRepository = themeRepository;
    }

    @Override
    public ResponseEntity<String> addThemeDetails(List<ThemeDTO> themeDTOList) {
        log.info("Received Theme List: {}", themeDTOList);
        if(themeDTOList.isEmpty()) {
            return new ResponseEntity<>("Theme Cannot be Empty", null, HttpStatus.BAD_REQUEST);
        }
        List<ThemeEntity> themeEntityList = new ArrayList<>();
        themeDTOList.forEach(theme -> {
            ThemeEntity themeEntity = CommonUtils.capitalizeAllStrings(themeMapper.themeDTOToThemeEntity(theme));
            themeEntity.setThemeName(StringUtils.capitalize(themeEntity.getThemeName()));
            themeEntityList.add(themeEntity);
        });
        log.info("Saving Genre List: {}", themeEntityList);
        List<ThemeEntity> themeEntitiesSaved = themeRepository.saveAll(themeEntityList);
        log.info("Successfully Saved Genre List: {}", themeEntitiesSaved);
        return new ResponseEntity<>("Successfully Added Themes", null, HttpStatus.CREATED);
    }

    @Override
    public Page<ThemeDTO> getAllThemes(Pageable page) {
        Page<ThemeEntity> themeEntities = themeRepository.findAll(page);
        log.info("Fetched themes : {}", themeEntities.getSize());
        return themeEntities.map(themeMapper::themeEntityToThemeDTO);
    }

    @Override
    public ThemeDTO getTheme(String id) {
        Optional<ThemeEntity> themeEntityOptional = themeRepository.findById(id);
        return themeEntityOptional.map(themeMapper::themeEntityToThemeDTO).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateTheme(String id, ThemeDTO themeDTO) {
        ThemeDTO theme = this.getTheme(id);
        if(theme != null) {
            theme.setThemeName(themeDTO.getThemeName());
            ThemeEntity themeEntity = CommonUtils.capitalizeAllStrings(themeMapper.themeDTOToThemeEntity(theme));
            themeRepository.save(themeEntity);
            return ResponseEntity.ok("Successfully updated Theme");
        }
        return new ResponseEntity<>("Theme Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteTheme(String id) {
        ThemeDTO theme = this.getTheme(id);
        if(theme != null) {
            themeRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted theme: '" + theme.getThemeName() + "'");
        }
        return new ResponseEntity<>("Theme Not Found", HttpStatus.NOT_FOUND);
    }
}
