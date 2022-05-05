package com.cricinfo.livescore.service;

import com.cricinfo.livescore.model.entity.User;
import com.cricinfo.livescore.model.request.UserRegistrationRequest;
import com.cricinfo.livescore.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @Mock private UserRepository userRepository;
    //@InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository,new BCryptPasswordEncoder());
    }

    @Test
    void when_save_user_it_should_return_user() {
        UserRegistrationRequest userRegistrationRequest = UserRegistrationRequest
                .builder()
                .username("test user")
                .email("test@gmail.com")
                .password("1234")
                .build();

        when(userRepository.save(any(User.class))).thenReturn(User.builder()
                .username("test user")
                .email("test@gmail.com")
                .password("1234")
                .build());

        User saved = userService.save(userRegistrationRequest);

        assertEquals("test user",saved.getUsername());
    }
}