package com.example.user.query.repository;

import com.example.user.query.domian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository
        extends JpaRepository<User, UUID> {
}
