package com.example.user.query.domian.dto;

public record KafkaStatus<T>(
        T data,
        String status
) {
}
