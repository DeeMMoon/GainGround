package com.gainground.gainGroung.service;

import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.repository.ProfileRepository;
import com.gainground.gainGroung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<ProfileEmpl> allProfilesEmpl() {
        return profileRepository.findAllByLeafsIsGreaterThan((long)-1);
    }
    public void setProfileLeafsById(Long profId, Long leafs) {
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(profId);
        if (profileRepository.findById(profId).isPresent()) {
            profileEmpl.setLeafs(leafs);
            profileRepository.save(profileEmpl);
        }
    }
}
