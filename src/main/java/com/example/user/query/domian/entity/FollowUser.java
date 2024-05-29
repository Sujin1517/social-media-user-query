package com.example.user.query.domian.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "FOLLOW_USERS")
public class FollowUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOW_USER_ID")
    private Long followUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLLOWER_ID")
    private User follower;
}
