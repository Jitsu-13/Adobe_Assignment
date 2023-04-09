package com.adobe.social_media.repository;

import com.adobe.social_media.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findTop5ByOrderByLikesDesc();
}
