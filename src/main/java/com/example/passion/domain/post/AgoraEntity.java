package com.example.passion.domain.post;

import com.example.passion.domain.etc.CategoryEntity;
import com.example.passion.domain.etc.TagEntity;
import com.example.passion.domain.user.UserEntity;
import com.example.passion.domain.comment.CommentEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AgoraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String portfolioId;// f key
    String title;   //제목임

    @OneToOne
    UserEntity userId; //f key

    @OneToOne
    @JoinColumn(name="categoryId")
    CategoryEntity categoryId;//카테고리 아이디

    String views;// 조회수
    @OneToMany
    @JoinColumn(name="comment")
    List<CommentEntity> commentEntityList = new ArrayList<>();// 외부 객체ㄹ임

    @OneToMany
    @JoinColumn(name = "tagId")
    List<TagEntity> tag = new ArrayList<>();// 태그도 새로 만들거임
}
