package com.gainground.gainGroung.repository;
import com.gainground.gainGroung.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PostRepository extends JpaRepository<Post,Long> {
List<Post> findAllByUserIdPost(Long id);
}
