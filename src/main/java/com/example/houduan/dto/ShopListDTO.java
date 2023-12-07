package com.example.houduan.dto;

import lombok.Data;

@Data
public class ShopListDTO {
    private Integer shopId;
    private String shopName;
    private Integer businessId;

    public ShopListDTO(Integer shopId, String shopName, Integer businessId) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.businessId = businessId;
    }
}
