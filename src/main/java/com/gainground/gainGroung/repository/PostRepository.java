package com.gainground.gainGroung.repository;


import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
List<Post> findAllByUserIdPost(Long id);
}
