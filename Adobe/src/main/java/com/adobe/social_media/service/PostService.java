package com.adobe.social_media.service;

import com.adobe.social_media.model.Post;

import java.util.List;

public interface PostService {

    public Post createPost(Post post);

    public Post getPostById(Integer id);

    public Post updatePost(Integer id, Post postRequest);

    public void deletePost(Integer id);

    public void incrementLikes(Integer id);

    public void decrementLikes(Integer id);

    public List<Post> getTopLikedPosts();

    public Integer getTotalPosts();



}
