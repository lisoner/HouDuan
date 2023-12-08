package com.example.houduan.Controller;

import com.example.houduan.dto.ItemListDTO;
import com.example.houduan.entity.Item;
import com.example.houduan.service.ItemService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping
public class ItemController {
    @Resource
    ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/BusinessItemList")
    public ResponseEntity<List<ItemListDTO>> BusinessItemList(Integer business_id){
        List<Item> itemList = itemService.getBusinessItemList(business_id);
        if(itemList != null){
            List<ItemListDTO> itemListDTOList = itemList.stream()
                    .map(item -> new ItemListDTO(item.getItemId(), item.getItemName(),item.getItemPrice(), item.getBusiness().getBusinessId()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(itemListDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/AddItem")
    public ResponseEntity<Item> addItem(Integer business_id, String item_name, Double item_price){
       try{
           Item newItem = itemService.addItem(business_id, item_name, item_price);

           if(newItem != null){
               return new ResponseEntity<Item>(newItem,HttpStatus.OK);
           }else {
               return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
           }
       }catch (NumberFormatException | NullPointerException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

}
