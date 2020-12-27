package com.gainground.gainGroung.repository;
import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.entity.Role;
import com.gainground.gainGroung.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByProfileEmpl(ProfileEmpl profileEmpl);
}
