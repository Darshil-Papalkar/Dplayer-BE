package com.dplay.dplayer.controller;

import com.dplay.dplayer.controller.common.GenericController;
import com.dplay.dplayer.dto.ThemeDTO;
import com.dplay.dplayer.enums.ThemeFieldsEnum;
import com.dplay.dplayer.service.serviceimpl.ThemeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ThemeController implements GenericController {
    private final ThemeServiceImpl themeService;

    public ThemeController(ThemeServiceImpl themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/admin/addTheme")
    public ResponseEntity<String> addTheme(@RequestBody ThemeDTO themes) {
        List<ThemeDTO> themeList = Arrays.stream(themes.getThemeName().split(",")).map(String::strip).filter(theme -> !theme.isEmpty()).map(theme -> {
            ThemeDTO themeDTO = new ThemeDTO();
            themeDTO.setThemeName(theme);
            return themeDTO;
        }).toList();
        return themeService.addThemeDetails(themeList);
    }

    @PutMapping("/admin/editTheme/{id}")
    public ResponseEntity<String> updateTheme(@PathVariable String id, @RequestBody ThemeDTO theme) {
        return themeService.updateTheme(id, theme);
    }

    @GetMapping("/admin/getAllThemes")
    public Page<ThemeDTO> getThemes(@RequestParam(defaultValue = "${default.pageNo}") int page,
                                    @RequestParam(defaultValue = "${default.pageSize}") int size,
                                    @RequestParam(defaultValue = "${default.entity}") ThemeFieldsEnum sortField,
                                    @RequestParam(defaultValue = "${default.direction}") Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, sortDirection, sortField.getDatabaseField());
        return themeService.getAllThemes(pageable);
    }

    @GetMapping("/admin/getTheme/{id}")
    public ResponseEntity<ThemeDTO> getTheme(@PathVariable String id) {
        ThemeDTO theme = themeService.getTheme(id);
        if (theme != null) return ResponseEntity.ok(theme);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admin/deleteTheme/{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable String id) {
        return themeService.deleteTheme(id);
    }
}
