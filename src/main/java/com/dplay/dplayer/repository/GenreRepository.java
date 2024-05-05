package com.dplay.dplayer.repository;

import com.dplay.dplayer.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GenreRepository extends MongoRepository<GenreEntity, String> {
}
