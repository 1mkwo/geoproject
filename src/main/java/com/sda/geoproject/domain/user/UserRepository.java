package com.sda.geoproject.domain.user;

import java.util.Optional;

public interface UserRepository {
    void create(User user);
    Optional<User> getByUsername(String username);
}
