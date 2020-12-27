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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveEmpl(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        ProfileEmpl profileEmpl = new ProfileEmpl();
        profileEmpl.setLeafs((long)0);
        if (profileEmpl.getFirst_name()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getLast_name()==null) profileEmpl.setLast_name("undefined");
        if (profileEmpl.getInformation()==null) profileEmpl.setLast_name("undefined");
        if (profileEmpl.getPhoneNumber()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getLocale()==null) profileEmpl.setLocale("undefined");
        if (profileEmpl.getAge()==null) profileEmpl.setAge("undefined");
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_EMPL")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfileEmpl(profileEmpl);
        profileEmpl.setProfile(user);
        userRepository.save(user);
        return true;
    }

    public User userRole(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return null;
        }

       return (User) userFromDB.getRoles();
    }

    public boolean saveEmplr(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        ProfileEmpl profileEmpl = new ProfileEmpl();
        profileEmpl.setLeafs((long)-1);
        if (profileEmpl.getFirst_name()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getLast_name()==null) profileEmpl.setLast_name("undefined");
        if (profileEmpl.getPhoneNumber()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getInformation()==null) profileEmpl.setLast_name("undefined");
        if (profileEmpl.getLocale()==null) profileEmpl.setLocale("undefined");
        if (profileEmpl.getAge()==null) profileEmpl.setAge("undefined");
        user.setRoles(Collections.singleton(new Role((long) 2, "ROLE_EMPLR")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfileEmpl(profileEmpl);
        profileEmpl.setProfile(user);
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


//   public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
}
