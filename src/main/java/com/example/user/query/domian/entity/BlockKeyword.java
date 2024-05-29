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
@Table(name = "BLOCK_KEYWORD")
public class BlockKeyword {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BLOCK_KEYWORD_ID")
    private Long blockKeywordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "BLOCK_KEYWORD")
    private String blockKeyword;
}
