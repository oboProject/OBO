package com.example.passion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="COMMENT")
public class CommentEntity extends BaseEntity{
    @Id
    private String commentId;
    private String commentBody;
    @ManyToOne(fetch = FetchType.LAZY)  //FetchType.EAGER, FetchType.LAZY로 전략을 변경 할 수 있습니다. 두 전략의 차이점은 EAGER인 경우 관계된 Entity의 정보를 미리 읽어오는 것이고 LAZY는 실제로 요청하는 순간 가져오는겁니다.
    @JoinColumn(name="USER_USERID")
    private long userId;

    //연관관계로 묶을 거면 객체가 와야되는데,,, postId 어카지,,,
    private String postId;
    private String mypick;
}
