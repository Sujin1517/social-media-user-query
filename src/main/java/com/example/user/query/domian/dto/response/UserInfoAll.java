package com.example.user.query.domian.dto.response;

import java.util.Date;
import java.util.UUID;

public record UserInfoAll(
        UUID id,
        String phone,
        String image,
        String name,
        String desc,
        Date createdAt,
        Integer totalPost,
        Integer totalLike,
        Integer totalFollower
) {
}
