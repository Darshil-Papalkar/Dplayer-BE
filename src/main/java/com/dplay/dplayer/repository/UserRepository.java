package com.dplay.dplayer.repository;

import com.dplay.dplayer.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByUserEmail(String userEmail);
}
