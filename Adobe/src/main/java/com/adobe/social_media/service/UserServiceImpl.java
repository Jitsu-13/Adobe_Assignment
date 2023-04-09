package com.adobe.social_media.service;

import com.adobe.social_media.exception.ResourceNotFoundException;
import com.adobe.social_media.model.User;
import com.adobe.social_media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
    }

    @Override
    public User updateUser(Integer id, User userRequest) {
       User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
       user.setName(userRequest.getName());
       user.setBio(userRequest.getBio());
       user.setUpdated_at(Instant.now());
       return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public Integer getTotalUsers() {
        return (int) userRepository.count();
    }

    @Override
    public List<User> getTopActiveUsers(int limit) {
        return userRepository.findTop5ByOrderByPostsDesc();
    }
}
