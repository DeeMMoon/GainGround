package com.gainground.gainGroung.service;

import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    public List<Post> authorPosts(Long id){
        return postRepository.findAllByUserIdPost(id);
    }
}
