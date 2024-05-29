package com.example.user.query.domian.dto;

import java.util.UUID;

public record UserInfoShort(
        UUID id,
        String image,
        String name
) {
}
