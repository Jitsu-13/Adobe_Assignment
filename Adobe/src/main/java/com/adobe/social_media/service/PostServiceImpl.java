package com.adobe.social_media.service;

import com.adobe.social_media.model.Post;
import com.adobe.social_media.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Override
    public Post getPostById(Integer id) {
        return null;
    }

    @Override
    public Post updatePost(Integer id, Post postRequest) {
        return null;
    }

    @Override
    public void deletePost(Integer id) {

    }

    @Override
    public void like(Integer id) {

    }

    @Override
    public void disLike(Integer id) {

    }

    @Override
    public List<Post> getTopLikedPosts(int limit) {
        return null;
    }

    @Override
    public Integer getTotalPosts() {
        return null;
    }
}
