package com.example.user.query.domian.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Table(name = "USERS")
public class User {
    @Id @Column(name = "USER_ID")
    private String user_id;

    @Column(name = "USER_IMAGE")
    private String user_image;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "USER_DESC")
    private String user_desc;

    @Column(name = "USER_TOTAL_POST")
    private Integer user_total_post;

    @Column(name = "USER_TOTAL_LIKE")
    private Integer user_total_like;

    @Column(name = "USER_DISABLE")
    private Boolean user_disable;
}
