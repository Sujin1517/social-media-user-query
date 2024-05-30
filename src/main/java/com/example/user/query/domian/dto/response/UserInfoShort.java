package com.example.user.query.domian.dto.response;

import com.example.user.query.domian.entity.BlockUser;
import com.example.user.query.domian.entity.FollowUser;

import java.util.UUID;

public record UserInfoShort(
        UUID id,
        String image,
        String name
) {
    public static UserInfoShort fromFollower(FollowUser user){
        return new UserInfoShort(
                user.getFollower().getId(),
                user.getFollower().getImage(),
                user.getFollower().getName()
        );
    }
    public static UserInfoShort fromBlockedUser(BlockUser user){
        return new UserInfoShort(
                user.getBlocked().getId(),
                user.getBlocked().getImage(),
                user.getBlocked().getName()
        );
    }
}
