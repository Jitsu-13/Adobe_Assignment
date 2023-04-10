package com.adobe.social_media.controller;

import com.adobe.social_media.model.Post;
import com.adobe.social_media.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Integer id, @Valid @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Post> likePost(@PathVariable("id") Integer id) {
        Post likedPost = postService.incrementLikes(id);
        return new ResponseEntity<>(likedPost, HttpStatus.OK);
    }

    @PostMapping("/{id}/unlike")
    public ResponseEntity<Post> unlikePost(@PathVariable("id") Integer id) {
        Post unlikedPost = postService.decrementLikes(id);
        return new ResponseEntity<>(unlikedPost, HttpStatus.OK);
    }

    @GetMapping("/analytics/posts")
    public ResponseEntity<Integer> getTotalPosts() {
        Integer totalPosts = postService.getTotalPosts();
        return new ResponseEntity<>(totalPosts, HttpStatus.OK);
    }

    @GetMapping("/analytics/posts/top-liked")
    public ResponseEntity<List<Post>> getTopLikedPosts() {
        List<Post> topLikedPosts = postService.getTopLikedPosts();
        return new ResponseEntity<>(topLikedPosts, HttpStatus.OK);
    }

}
