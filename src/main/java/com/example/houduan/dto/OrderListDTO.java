package com.example.houduan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderListDTO {
    private Integer orderId;
    private Integer itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQuantity;
}
