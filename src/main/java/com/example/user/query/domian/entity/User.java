package com.example.user.query.domian.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Table(name = "USERS")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private UUID userId;

    @Column(name = "USER_PHONE")
    private String userPhone;

    @Column(name = "USER_IMAGE")
    private String userImage;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_DESC")
    private String userDesc;

    @Column(name = "USER_CREATED_AT")
    private Date userCreatedAt;

    @Column(name = "USER_TOTAL_POST")
    private Integer userTotalPost;

    @Column(name = "USER_TOTAL_LIKE")
    private Integer userTotalLike;

    @Column(name = "USER_DISABLE")
    private Boolean userDisable;


    @OneToMany(mappedBy = "user")
    private List<FollowUser> followUser;

    @OneToMany(mappedBy = "user")
    private List<BlockUser> blockUser;

    @OneToMany(mappedBy = "user")
    private List<BlockKeyword> blockKeyword;
}
