package com.example.houduan.Controller;

import com.example.houduan.dto.ItemDTO;
import com.example.houduan.entity.Item;
import com.example.houduan.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "Item", description = "ItemController")
public class ItemController {
    @Resource
    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "根据商家id查ItemList" ,description = "")
    @PostMapping("/BusinessItemList")
    public List<ItemDTO> BusinessItemList(Integer business_id) {
        return itemService.getBusinessItemList(business_id);
    }

    @Operation(summary = "新增Item" ,description = "")
    @PostMapping("/AddItem")
    public ItemDTO addItem(Integer business_id, String item_name, Double item_price) {
        return itemService.addItem(business_id, item_name, item_price);
    }

}
