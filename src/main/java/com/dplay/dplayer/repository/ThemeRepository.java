package com.dplay.dplayer.repository;

import com.dplay.dplayer.entity.ThemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThemeRepository extends MongoRepository<ThemeEntity, String> {
}
