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
@Table(name = "BLOCK_USERS")
public class BlockUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BLOCK_USER_ID")
    private Long blockUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BLOCKED_USER_ID")
    private User blocked;
}
