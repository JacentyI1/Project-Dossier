package com.jack.projectdossier.services.impl;

import com.jack.projectdossier.dao.entities.UserEntity;
import com.jack.projectdossier.repositories.UserRepository;
import com.jack.projectdossier.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        // encode password
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        // set password parameter
        userEntity.setPassword(encodedPassword);
        // save user in the repository
        userRepository.save(userEntity);
        // return saved user for debugging (maybe something else)
        return userEntity;
    }


}
