package com.adobe.social_media.repository;

import com.adobe.social_media.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findTop5ByOrderByPostsDesc();
}
