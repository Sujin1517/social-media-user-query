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
    @Id
    @Column(name = "USER_ID")
    private UUID id;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_PHONE")
    private String phone;

    @Column(name = "USER_IMAGE")
    private String image;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_DESC")
    private String desc;

    @Column(name = "USER_CREATED_AT")
    private Date createdAt;

    @Column(name = "USER_TOTAL_POST")
    private Integer totalPost;

    @Column(name = "USER_TOTAL_LIKE")
    private Integer totalLike;

    @Column(name = "USER_TOTAL_FOLLOWER")
    private Integer totalFollower;

    @Column(name = "USER_DISABLE")
    private Boolean isDisable;


    @OneToMany(mappedBy = "user")
    private List<FollowUser> followUser;

    @OneToMany(mappedBy = "user")
    private List<BlockUser> blockUser;

    @OneToMany(mappedBy = "user")
    private List<BlockKeyword> blockKeyword;


    public void update(User req) {
        image = req.getImage();
        name = req.getName();
        desc = req.getDesc();
    }

    public void increaseTotalPost() {
        totalPost++;
    }
    public void increaseTotalLike() {
        totalLike++;
    }

    public void decreaseTotalPost() {
        if(totalPost <= 0) throw new IllegalArgumentException();
        totalPost--;
    }
    public void decreaseTotalLike() {
        if(totalLike <= 0) throw new IllegalArgumentException();
        totalLike--;
    }

    public void disable() {
        isDisable = true;
    }
}
