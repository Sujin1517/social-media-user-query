package com.example.user.query.service;

import com.example.user.query.domian.dto.KafkaStatus;
import com.example.user.query.domian.dto.UserInfoAll;
import com.example.user.query.domian.dto.UserInfoShort;
import com.example.user.query.domian.entity.User;
import com.example.user.query.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserInfoAll getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new UserInfoAll(
                user.getId(),
                user.getPhone(),
                user.getImage(),
                user.getName(),
                user.getDesc(),
                user.getCreatedAt(),
                user.getTotalPost(),
                user.getTotalLike(),
                user.getTotalFollower()
        );
    }

    @Override
    public List<UserInfoShort> getFollowingUsersById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return user.getFollowUser().stream()
                .map(UserInfoShort::fromFollower)
                .toList();
    }

    @Override
    public List<UserInfoShort> getBlockedUsersById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return user.getBlockUser().stream()
                .map(UserInfoShort::fromBlockedUser)
                .toList();
    }

    @Override
    public void saveUser(User req) {
        User user = User.builder()
                .id(req.getId())
                .phone(req.getPhone())
                .image(req.getImage())
                .name(req.getName())
                .desc(req.getDesc())
                .createdAt(req.getCreatedAt())
                .totalPost(0)
                .totalLike(0)
                .isDisable(false)
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        user.update(req);
    }

    @Override
    public void deleteUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        user.disable();
    }

    @Override
    public void increaseLikeCountByUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        user.increaseTotalLike();
    }

    @Override
    public void increasePostCountByUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        user.increaseTotalPost();
    }

    @Override
    public void decreaseLikeCountByUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        user.decreaseTotalLike();
    }

    @Override
    public void decreasePostCountByUser(User req) {
        User user = userRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
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
