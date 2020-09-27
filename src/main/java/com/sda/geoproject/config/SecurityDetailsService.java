package com.sda.geoproject.config;

import com.sda.geoproject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByUsername(username)
                .map(usr-> new User(usr.getUsername(), usr.getPassword(), mapRole(usr.getRole())))
                .orElseThrow(()-> new UsernameNotFoundException("User does not exist"));
    }

    private List<GrantedAuthority> mapRole(String role){
        GrantedAuthority authority= new SimpleGrantedAuthority("ROLE_"+ role);
        return Collections.singletonList(authority);
    }
}

