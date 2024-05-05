package com.dplay.dplayer.mapper;

import com.dplay.dplayer.dto.UserDTO;
import com.dplay.dplayer.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "userEmail", target = "userEmail")
    @Mapping(source = "userPassword", target = "userPassword")
    UserEntity userDTOToUserEntity(UserDTO userDTO);
}
