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
    @JoinColumn(
            name = "shop_id",
            referencedColumnName = "shopId")
    private Shop shop;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "item_id",
            referencedColumnName = "itemId")
    private Item item;
}