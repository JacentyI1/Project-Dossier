package com.jack.projectdossier.controllers;

import com.jack.projectdossier.dao.dtos.UserDto;
import com.jack.projectdossier.dao.entities.UserEntity;
import com.jack.projectdossier.mappers.Mapper;
import com.jack.projectdossier.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(...)
@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    private final Mapper<UserEntity, UserDto> userMapper;

    @PostMapping(path = "/signup")
    public UserEntity createUser(@RequestBody UserDto userDto){
        // parse to UserEntity
        UserEntity userEntity = userMapper.mapFrom(userDto);
        // create user in the user repository
        return userService.createUser(userEntity);
    }
}
