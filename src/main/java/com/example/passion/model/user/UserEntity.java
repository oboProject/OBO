package com.example.passion.model.user;

import com.example.passion.constant.Withdrawal;
import com.example.passion.model.base.BaseEntity;
import com.example.passion.model.post.PortfolioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;

    String displayName;

    @Email
    String email;

    String password;

    String state;

    String city;

    String userInfo;

    String career;

    String education;

    String company;

    Withdrawal withdrawal;// 객체로 대체할것

    @OneToMany
    List<PortfolioEntity> portfolioEntities = new ArrayList<>();

    public UserEntity update(String userId, String displayName, String email, String password, String state,
                             String city, String userInfo, String career, String education, String company) {
        this.userId = userId;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.state = state;
        this.city = city;
        this.userInfo = userInfo;
        this.career = career;
        this.education = education;
        this.company = company;

        return this;
    }

    //
//    @ManyToOne
//    @JoinColumn
//    private UserEntity userFollowing = this;
//
//    @ManyToOne
//    @JoinColumn
//    private UserEntity userFollower = this;
//
//    @OneToMany(mappedBy = "userFollowing")
//    private List<UserEntity> followingList = new ArrayList<UserEntity>();
//
//    @OneToMany(mappedBy = "userFollower")
//    private List<UserEntity> followerList = new ArrayList<UserEntity>();
//
//    public void addFollowing(UserEntity following) {
//        this.followingList.add(following);
//
//        if(!following.getFollowerList().contains(this)) {
//            following.getFollowerList().add(this);
//        }
//        //연관관계의 주인을 통한 확인
//        if(!following.getUserFollower().getFollowerList().contains(this)) {
//            following.getUserFollower().getFollowerList().add(this);
//        }
//    }
//    public void addFollower(UserEntity follower) {
//
//        this.followerList.add(follower);
//
//        if(follower.getFollowingList().contains(this)) {
//            follower.getFollowingList().add(this);
//        }
//        //연관관계의 주인을 통한 확인
//        if(!follower.getUserFollowing().getFollowingList().contains(this)) {
//            follower.getUserFollowing().getFollowingList().add(this);
//        }
//    }


}