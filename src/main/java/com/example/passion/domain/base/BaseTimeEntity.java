package com.example.passion.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.relational.core.mapping.Column;

//@EntityListeners(value={AuditingEntityListener.class})
//@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {
    @CreatedDate
    @Column
    private LocalDateTime regTime;//등록시간

    @LastModifiedDate
    private LocalDateTime updateTime;//수정시간
}
