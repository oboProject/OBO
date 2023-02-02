package com.example.passion.model.etc;

import com.example.passion.constant.Withdrawal;
import com.example.passion.model.base.BaseEntity;
import com.example.passion.model.user.UserEntity;
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
@Table(name="MYPICK")
public class MypickEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String mypickId;

    @ManyToOne
    @JoinColumn(name="USER")
    private UserEntity userId;

    Withdrawal withdrawal;// 객체로 대체할것
}
