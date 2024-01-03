package com.example.houduan.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTableDTO {
    private Integer orderId;
    private Integer orderState;
    private Double orderCost;
    private Integer shopId;
    private String shopName;
    private Integer customerId;
    private String customerName;
}
