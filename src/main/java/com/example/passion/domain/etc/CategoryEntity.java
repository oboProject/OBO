package com.example.passion.domain.etc;


import com.example.passion.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CATEGORY")
public class CategoryEntity extends BaseEntity {
    @Id
    private String categoryId;
    private String categoryName;
}

// @GeneratedValue & @GenericGenerator  아직 안넣음.