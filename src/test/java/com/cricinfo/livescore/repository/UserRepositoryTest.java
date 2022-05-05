package com.cricinfo.livescore.repository;

import com.cricinfo.livescore.model.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void shouldCheckUserEqualsFindByUsername() {
        User user = User.builder().username("userA")
                .email("usera@gmail.com")
                .password("1234").build();

        userRepository.save(user);
        Optional<User> result = userRepository.findByUsername("userA");
        assertNotNull(result);
        result.ifPresent(value -> assertEquals(user, value));

    }

    @Test
    void itShouldCheckWhenUserEmailExists() {
        // given
        String email = "usera@gmail.com";
        User user = User.builder().username("userA")
                .email(email)
                .password("1234").build();

        userRepository.save(user);

        // when
        boolean expected = userRepository.existsByEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenUserEmailDoesNotExists() {
        // given
        String email = "usera@gmail.com";

        // when
        boolean expected = userRepository.existsByEmail(email);

        // then
        assertThat(expected).isFalse();
    }
}