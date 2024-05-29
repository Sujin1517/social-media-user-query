package com.example.user.query.service;

import com.example.user.query.domian.dto.KafkaStatus;
import com.example.user.query.domian.entity.User;
import com.example.user.query.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        User user = User.builder()
                .userId(req.getUserId())
                .userPhone(req.getUserPhone())
                .userImage(req.getUserImage())
                .userName(req.getUserName())
                .userDesc(req.getUserDesc())
                .userCreatedAt(req.getUserCreatedAt())
                .userTotalPost(0)
                .userTotalLike(0)
                .userDisable(false)
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.update(req);
    }

    @Override
    public void deleteUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.disable();
    }

    @Override
    public void increaseLikeCountByUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.increaseTotalLike();
    }

    @Override
    public void increasePostCountByUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.increaseTotalPost();
    }

    @Override
    public void decreaseLikeCountByUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.decreaseTotalLike();
    }

    @Override
    public void decreasePostCountByUser(User req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.decreaseTotalPost();
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
