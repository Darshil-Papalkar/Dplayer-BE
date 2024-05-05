package com.dplay.dplayer.controller;

import com.dplay.dplayer.controller.common.GenericController;
import com.dplay.dplayer.dto.UserDTO;
import com.dplay.dplayer.service.serviceimpl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements GenericController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/login", produces = "application/json")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        return userService.loginUser(userDTO);
    }

    @PostMapping(value = "/user/create", produces = "application/json")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
