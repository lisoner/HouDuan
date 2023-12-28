package com.example.houduan.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    private String shopName;
    private Integer isDeleted;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "businessId",/*这里和数据库表的列名对应*/
            referencedColumnName = "businessId"/*这里和entity的Business类里面的属性对应*/
    )
    private Business business;
}
