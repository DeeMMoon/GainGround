package com.gainground.gainGroung.repository;

import com.gainground.gainGroung.entity.Role;
import com.gainground.gainGroung.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
