package com.example.houduan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Integer itemId;
    private String itemName;
    private Double itemPrice;
    private Integer businessId;

}
