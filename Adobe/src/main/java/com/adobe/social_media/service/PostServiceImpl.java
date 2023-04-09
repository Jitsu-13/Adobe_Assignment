package com.adobe.social_media.service;

import com.adobe.social_media.exception.ResourceNotFoundException;
import com.adobe.social_media.model.Post;
import com.adobe.social_media.model.User;
import com.adobe.social_media.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    @Override
    public Post createPost(Post post) {
        User user=userService.getUserById(post.getUser().getId());
        post.setUser(user);
        post.setCreated_at(Instant.now());
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
    }

    @Override
    public Post updatePost(Integer id, Post postRequest) {
        Post post =postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        post.setContent(postRequest.getContent());
        post.setUpdated_at(Instant.now());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public void incrementLikes(Integer id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        post.setLikes(post.getLikes()+1);
        postRepository.save(post);
    }

    @Override
    public void decrementLikes(Integer id) {
        Post post= postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        int likes=post.getLikes()-1;
        post.setLikes(likes>=0 ? likes:0);
        postRepository.save(post);
    }

    @Override
    public List<Post> getTopLikedPosts() {
        return postRepository.findTop5ByOrderByLikesDesc();
    }


    @Override
    public Integer getTotalPosts() {
        return (int)postRepository.count();
    }
}
