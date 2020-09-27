package com.sda.geoproject.domain.user;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;

    public void encodePassword(PasswordEncoder passwordEncoder, String rawPassword){
        this.password= passwordEncoder.encode(rawPassword);
    }
}
