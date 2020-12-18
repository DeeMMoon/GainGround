package com.gainground.gainGroung.service;

import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.repository.ProfileRepository;
import com.gainground.gainGroung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class PostService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ProfileRepository profileRepository;
    public List<Post> authorPosts(Long id){
        return postRepository.findAllByUserIdPost(id);
    }

}
