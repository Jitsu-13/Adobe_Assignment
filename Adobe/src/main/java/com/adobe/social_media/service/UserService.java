package com.adobe.social_media.service;

import com.adobe.social_media.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public User getUserById(Integer id);

    public User updateUser(Integer id, User userRequest);

    public void deleteUser(Integer id);

    public Integer getTotalUsers();

    public List<User> getTopActiveUsers(int limit);

}
