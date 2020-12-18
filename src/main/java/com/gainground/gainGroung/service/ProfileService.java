package com.gainground.gainGroung.service;

import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.entity.Role;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.repository.ProfileRepository;
import com.gainground.gainGroung.repository.RoleRepository;
import com.gainground.gainGroung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class ProfileService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ProfileRepository profileRepository;

    public List<ProfileEmpl> allProfiles() {
        return profileRepository.findAll();
    }
    public void setProfileLeafsById(Long profId, Integer leafs) {
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(profId);
        if (profileRepository.findById(profId).isPresent()) {
            profileEmpl.setLeafs(leafs);
            profileRepository.save(profileEmpl);
        }
    }
}
