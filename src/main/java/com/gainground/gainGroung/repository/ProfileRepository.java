package com.gainground.gainGroung.repository;
import com.gainground.gainGroung.entity.ProfileEmpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<ProfileEmpl,Long> {
ProfileEmpl findProfileEmplById(Long id);
List<ProfileEmpl> findAllByLeafsIsGreaterThan(Long leaf);
}
