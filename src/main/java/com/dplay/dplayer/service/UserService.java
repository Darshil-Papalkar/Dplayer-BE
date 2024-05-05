package com.dplay.dplayer.service;


import com.dplay.dplayer.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> loginUser(UserDTO userDTO);

    ResponseEntity<String> createUser(UserDTO userDTO);

}
