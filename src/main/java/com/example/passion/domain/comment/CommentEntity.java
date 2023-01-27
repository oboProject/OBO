package com.example.passion.domain.comment;

import com.example.passion.domain.etc.MypickEntity;
import com.example.passion.domain.post.PortfolioEntity;
import com.example.passion.domain.user.UserEntity;
import com.example.passion.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="COMMENT")
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String commentId;

    private String commentBody;

    @ManyToOne(fetch = FetchType.LAZY)  //FetchType.EAGER, FetchType.LAZY로 전략을 변경 할 수 있습니다. 두 전략의 차이점은 EAGER인 경우 관계된 Entity의 정보를 미리 읽어오는 것이고 LAZY는 실제로 요청하는 순간 가져오는겁니다.
    @JoinColumn(name="USER_USERID")
    private UserEntity userId;

    //연관관계로 묶을 거면 객체가 와야되는데,,, postId 어카지,,,
    private String postId;

    @ManyToOne
    @JoinColumn(name="portfolioId")
    private PortfolioEntity portfolioEntity;

    @OneToMany
    @JoinColumn(name="myPickEntityId")
    private List<MypickEntity> myPickEntityList = new ArrayList<>();
}
