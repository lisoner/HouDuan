package org.example.controller;

import org.example.service.ItemService;
import org.example.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 商家新建商品
    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto itemDTO) {
        return itemService.createItem(itemDTO);
    }
}
