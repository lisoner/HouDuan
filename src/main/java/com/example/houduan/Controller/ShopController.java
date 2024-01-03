package com.example.houduan.Controller;

import com.example.houduan.dto.ShopDTO;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "Shop", description = "ShopController")
public class ShopController {
    @Resource
    ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @Operation(summary = "列出所有的门店信息" ,description = "")
    @PostMapping("/AllShopList")
    public List<ShopDTO> AllShopList() {
        return shopService.getAllShopList();
    }

    @Operation(summary = "根据商家id查门店列表" ,description = "")
    @PostMapping("/BusinessShopList")
    public List<ShopDTO> BusinessShopList(Integer business_id) {
        return shopService.findShopsByBusiness_BusinessIdAndIsDeletedIsNull(business_id);
    }

    @Operation(summary = "新增/更新 门店" ,description = "")
    @PostMapping("/AddShop")
    public ShopDTO addShop(Integer business_id, String shop_name) {
        return shopService.addShop(business_id, shop_name);
    }

    @PostMapping("/DeleteShop")
    public ShopDTO deleteShop(String shop_name) {
        return shopService.deleteShop(shop_name);
    }
}
