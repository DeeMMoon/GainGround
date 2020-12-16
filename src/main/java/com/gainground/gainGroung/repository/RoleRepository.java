package com.gainground.gainGroung.repository;
import com.gainground.gainGroung.entity.Role;
import com.gainground.gainGroung.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(User id);
}
