package com.example.houduan.Controller;

import com.example.houduan.dto.ItemListDTO;
import com.example.houduan.entity.ShopItem;
import com.example.houduan.service.ShopItemService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class ShopItemController {
    @Resource
    ShopItemService shopItemService;
    @Autowired
    public ShopItemController(ShopItemService shopItemService){
        this.shopItemService = shopItemService;
    }

    @PostMapping("/ShopItemList")
    public ResponseEntity<List<ShopItem>> shopItemList(Integer shop_id){
        try{
            List<ShopItem> shopItemList = shopItemService.shopItemList(shop_id);

            if(shopItemList != null){
                return new ResponseEntity<List<ShopItem>>(shopItemList, HttpStatus.OK);
            }else {
                return new ResponseEntity<List<ShopItem>>(HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/AddShopItem")
    public ResponseEntity<ShopItem> addShopItem(Integer shop_id, Integer item_id){
        try{
            ShopItem newShopItem = shopItemService.addShopItem(shop_id, item_id);

            if((newShopItem.getShop()!=null) && (newShopItem.getItem()!=null)){
                return new ResponseEntity<ShopItem>(newShopItem, HttpStatus.OK);
            }else {
                return new ResponseEntity<ShopItem>(HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/DeleteShopItem")
    public String deleteShopItem(Integer shop_id, Integer item_id){
        try{
            Integer number = shopItemService.deleteShopItem(shop_id, item_id);
            if(number == 1){
                return "删除成功";
            }else if(number == 0){
                return "删除失败";
            }else{
                return "未知原因删除失败";
            }
        } catch (NumberFormatException | NullPointerException e) {
            return "HttpStatus.BAD_REQUEST";
        }
    }
}
