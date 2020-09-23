package com.sda.geoproject.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public void registerUser(User user){
        if (userRepository.getByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User with given login already exists");
        }
        userRepository.create(user);
    }
}
