package com.example.user.query.service;

import com.example.user.query.domian.dto.KafkaStatus;
import com.example.user.query.domian.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);
    List<User> getFollowingUsersById(String id);
    List<User> getBlockedUsersById(String id);
    void saveUser(User req);
    void updateUser(User req);
    void deleteUser(User req);
    void increaseLikeCountByUser(User req);
    void increasePostCountByUser(User req);
    void decreaseLikeCountByUser(User req);
    void decreasePostCountByUser(User req);

    void listener(KafkaStatus<User> status);
}
