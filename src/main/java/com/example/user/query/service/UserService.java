package com.example.user.query.service;

import com.example.user.query.domian.dto.KafkaStatus;
import com.example.user.query.domian.dto.UserInfoAll;
import com.example.user.query.domian.dto.UserInfoShort;
import com.example.user.query.domian.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserInfoAll getUserById(UUID id);
    List<UserInfoShort> getFollowingUsersById(UUID id);
    List<UserInfoShort> getBlockedUsersById(UUID id);
    void saveUser(User req);
    void updateUser(User req);
    void deleteUser(User req);
    void increaseLikeCountByUser(User req);
    void increasePostCountByUser(User req);
    void decreaseLikeCountByUser(User req);
    void decreasePostCountByUser(User req);

    void listener(KafkaStatus<User> status);
}
