package com.sda.geoproject.domain.user;

import lombok.*;

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
}
