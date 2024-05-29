package com.example.user.query.controller;

import com.example.user.query.domian.dto.UserInfoAll;
import com.example.user.query.domian.dto.UserInfoShort;
import com.example.user.query.domian.entity.User;
import com.example.user.query.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vi/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserInfoAll getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/followers")
    public List<UserInfoShort> getFollowingUsersById(@PathVariable UUID id) {
        return userService.getFollowingUsersById(id);
    }

    @GetMapping("/{id}/blocks")
    public List<UserInfoShort> getBlockedUsersById(@PathVariable UUID id) {
        return userService.getBlockedUsersById(id);
    }
}
