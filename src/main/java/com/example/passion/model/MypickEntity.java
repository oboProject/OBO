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
@Table(name="MYPICK")
public class MypickEntity extends BaseEntity{
    @Id
    private String mypickId;
    @ManyToOne
    @JoinColumn(name="USER")
    private String userId;

    String withdrawal;// 객체로 대체할것
}
