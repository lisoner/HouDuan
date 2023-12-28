package com.example.houduan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopListDTO {
    private Integer shopId;
    private String shopName;
    private Integer businessId;

}
