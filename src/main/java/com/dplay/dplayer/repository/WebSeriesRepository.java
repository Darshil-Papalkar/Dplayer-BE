package com.dplay.dplayer.repository;

import com.dplay.dplayer.entity.WebSeriesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebSeriesRepository extends MongoRepository<WebSeriesEntity, String> {
}
