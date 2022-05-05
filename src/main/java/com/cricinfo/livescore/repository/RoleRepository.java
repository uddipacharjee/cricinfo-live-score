package com.cricinfo.livescore.repository;

import com.cricinfo.livescore.model.entity.Role;
import com.cricinfo.livescore.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleEnum name);
}
