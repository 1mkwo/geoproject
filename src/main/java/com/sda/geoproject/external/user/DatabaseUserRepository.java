package com.sda.geoproject.external.user;

import com.sda.geoproject.domain.user.User;
import com.sda.geoproject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class DatabaseUserRepository implements UserRepository {

    private final JpaUserRepository userRepository;

    @Override
    public void create(User user) {
        UserEntity entity= UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        userRepository.save(entity);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(ent-> new User(ent.getId(),
                        ent.getUsername(),
                        ent.getPassword(),
                        ent.getRole()));
    }
}
