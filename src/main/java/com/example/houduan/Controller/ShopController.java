package com.example.houduan.Controller;

import com.example.houduan.dto.ShopListDTO;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.ShopService;
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
public class ShopController {
    @Resource
    ShopService shopService;
    @Autowired
    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @PostMapping("/AllShopList")
    public ResponseEntity<List<ShopListDTO>> AllShopList(){
        List<Shop> shopList = shopService.getAllShopList();
        if (shopList != null){
            List<ShopListDTO> shopListDTOList = shopList.stream()
                    .map(shop -> new ShopListDTO(shop.getShopId(), shop.getShopName(), shop.getBusiness().getBusinessId()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(shopListDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/BusinessShopList")
    public ResponseEntity<List<ShopListDTO>> BusinessShopList(Integer business_id){
        List<Shop> shopList = shopService.getBusinessShopList(business_id);
        if(shopList != null){
            List<ShopListDTO> shopListDTOList = shopList.stream()
                    .map(shop -> new ShopListDTO(shop.getShopId(), shop.getShopName(), shop.getBusiness().getBusinessId()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(shopListDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/AddShop")
    public ResponseEntity<Shop> addShop(Integer business_id, String shop_name){
        try{
            Shop newShop = shopService.addShop(business_id, shop_name);

            if(newShop != null){
                return new ResponseEntity<Shop>(newShop,HttpStatus.OK);
            }else {
                return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/DeleteShop")
    public String deleteShop(String shop_name){
        try {
            Shop shop = shopService.deleteShop(shop_name);
            if(shop != null){
                return "删除成功";
            }else {
                return "删除失败";
            }
        } catch (NumberFormatException | NullPointerException e) {
            return "请求异常";
        }
    }
}
