package com.example.houduan.entity;

import com.example.houduan.serviceImpl.ItemServiceImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "shop_item")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "shopId", referencedColumnName = "shopId"),
            @JoinColumn(name = "shopName", referencedColumnName = "shopName"),
    })
    private Shop shop;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "itemId", referencedColumnName = "itemId"),
            @JoinColumn(name = "itemName", referencedColumnName = "itemName"),
    })
    private Item item;
}
