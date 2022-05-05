package com.cricinfo.livescore.service;

import com.cricinfo.livescore.model.entity.User;
import com.cricinfo.livescore.model.request.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationRequest userRegistrationRequest);
}
