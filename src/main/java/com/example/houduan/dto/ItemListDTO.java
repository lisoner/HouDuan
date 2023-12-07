package com.example.houduan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemListDTO {
    private Integer itemId;
    private String itemName;
    private Double itemPrice;
    private Integer businessId;

}
