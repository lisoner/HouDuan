package com.example.houduan.Controller;

import com.example.houduan.dto.ShopListDTO;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ShopListDTO> AllShopList() {
        return shopService.getAllShopList();
    }

    @Operation(summary = "根据商家id查门店列表" ,description = "")
    @PostMapping("/BusinessShopList")
    public List<ShopListDTO> BusinessShopList(Integer business_id) {
        return shopService.getBusinessShopList(business_id);
    }

    @Operation(summary = "新增/更新 门店" ,description = "")
    @PostMapping("/AddShop")
    public boolean addShop(Integer business_id, String shop_name) {
        Shop shop = shopService.addShop(business_id, shop_name);
        return true;
    }

    @PostMapping("/DeleteShop")
    public boolean deleteShop(String shop_name) {
        Shop shop = shopService.deleteShop(shop_name);
        return true;
    }
}
