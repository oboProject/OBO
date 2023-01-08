package com.example.passion.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@EntityListeners(value={AuditingEntityListener.class})
@MappedSuperclass
@Getter
public abstract class BaseEntity extends BaseTimeEntity {
    @CreatedBy
//    @Column(updatable = false)
    @Column
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;
}
