package com.example.houduan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopItemDTO {
    private Integer itemId;
    private Integer shopId;
    private String shopName;
    private String itemName;
    private Double itemPrice;
}
