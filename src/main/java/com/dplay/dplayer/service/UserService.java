package com.dplay.dplayer.service;


import com.dplay.dplayer.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> loginUser(UserDTO userDTO);

    ResponseEntity<String> createUser(UserDTO userDTO);

}
