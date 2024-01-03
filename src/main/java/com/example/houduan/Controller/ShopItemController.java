package com.example.houduan.Controller;

import com.example.houduan.dto.ShopItemDTO;
import com.example.houduan.entity.ShopItem;
import com.example.houduan.service.ShopItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "ShopItem", description = "ShopItemController")
public class ShopItemController {
    @Resource
    ShopItemService shopItemService;
    @Autowired
    public ShopItemController(ShopItemService shopItemService){
        this.shopItemService = shopItemService;
    }

    @Operation(summary = "根据门店id查门店下的上架商品" ,description = "")
    @PostMapping("/ShopItemList")
    public List<ShopItemDTO> shopItemList(Integer shop_id){
        return shopItemService.shopItemList(shop_id);
    }

    @Operation(summary = "在门店上架商品" ,description = "")
    @PostMapping("/AddShopItem")
    public ShopItemDTO addShopItem(Integer shop_id, Integer item_id){
        return shopItemService.addShopItem(shop_id, item_id);
    }

    @Operation(summary = "在门店下架商品" ,description = "")
    @PostMapping("/DeleteShopItem")
    public boolean deleteShopItem(Integer shop_id, Integer item_id) {
        Integer number = shopItemService.deleteShopItem(shop_id, item_id);
        return true;
    }
}
