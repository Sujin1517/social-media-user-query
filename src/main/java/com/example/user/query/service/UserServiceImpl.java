package com.example.user.query.service;

import com.example.user.query.domian.dto.KafkaStatus;
import com.example.user.query.domian.entity.User;
import com.example.user.query.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public List<User> getFollowingUsersById(String id) {
        return List.of();
    }

    @Override
    public List<User> getBlockedUsersById(String id) {
        return List.of();
    }

    @Override
    public void saveUser(User req) {

    }

    @Override
    public void updateUser(User req) {

    }

    @Override
    public void deleteUser(User req) {

    }

    @Override
    public void increaseLikeCountByUser(User req) {

    }

    @Override
    public void increasePostCountByUser(User req) {

    }

    @Override
    public void decreaseLikeCountByUser(User user) {

    }

    @Override
    public void decreasePostCountByUser(User user) {

    }

    @Override
    @Transactional
    @KafkaListener(topics = "user-events")
    public void listener(KafkaStatus<User> status) {
        switch (status.status()){
            case "insert" -> saveUser(status.data());
            case "update" -> updateUser(status.data());
            case "delete" -> deleteUser(status.data());
        }
    }
}
