package com.cricinfo.livescore.service;

import com.cricinfo.livescore.exception.BadRequestException;
import com.cricinfo.livescore.model.entity.Role;
import com.cricinfo.livescore.model.entity.User;
import com.cricinfo.livescore.model.UserPrincipal;
import com.cricinfo.livescore.model.enums.RoleEnum;
import com.cricinfo.livescore.model.request.UserRegistrationRequest;
import com.cricinfo.livescore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new UserPrincipal(user);
    }


    @Override
    public User save(UserRegistrationRequest userRegistrationRequest) {
        Boolean userNameExist = userRepository.existsByUsername(userRegistrationRequest.getUsername());
        if(userNameExist){
            throw new BadRequestException("username already taken");
        }
        Boolean emailExist = userRepository.existsByEmail(userRegistrationRequest.getEmail());
        if(emailExist){
            throw new BadRequestException("email already taken");
        }
        User user = User.builder()
                .username(userRegistrationRequest.getUsername())
                .email(userRegistrationRequest.getEmail())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .roles(new HashSet<>(List.of(Role.builder().id(1L).name(RoleEnum.ROLE_USER).build())))
                .build();

        return userRepository.save(user);
    }
}
