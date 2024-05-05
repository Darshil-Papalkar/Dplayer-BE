package com.dplay.dplayer.service.serviceimpl;

import com.dplay.dplayer.dto.UserDTO;
import com.dplay.dplayer.entity.UserEntity;
import com.dplay.dplayer.mapper.UserMapper;
import com.dplay.dplayer.repository.UserRepository;
import com.dplay.dplayer.service.UserService;
import com.dplay.dplayer.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    private HttpHeaders getHeaders() {
        return new HttpHeaders();
    }

    @Override
    public ResponseEntity<String> loginUser(UserDTO userDTO) {

        log.info("Login User with: {}", userDTO.toString());
        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);
        Optional<UserEntity> user = userRepository.findByUserEmail(userEntity.getUserEmail());
        if(user.isEmpty() || Boolean.FALSE.equals(CommonUtils.validatePassword(user.get().getUserPassword(), userEntity.getUserPassword()))) {
            return new ResponseEntity<>("Invalid User Email/Password", getHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get().getId(), getHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createUser(UserDTO userDTO) {
        log.info("Register User with: {}", userDTO.toString());
        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);
        Optional<UserEntity> user = userRepository.findByUserEmail(userEntity.getUserEmail());
        if(user.isPresent()) {
            return new ResponseEntity<>("Already Registered, Please login Instead.", getHeaders(), HttpStatus.BAD_REQUEST);
        }
        userEntity.setUserPassword(CommonUtils.hashPassword(userEntity.getUserPassword()));
        userEntity = userRepository.save(userEntity);
        return new ResponseEntity<>(userEntity.getId(), getHeaders(), HttpStatus.CREATED);
    }
}
