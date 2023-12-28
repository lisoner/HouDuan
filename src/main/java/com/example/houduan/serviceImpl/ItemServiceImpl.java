package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IItemDao;
import com.example.houduan.dto.ItemDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Item;
import com.example.houduan.service.ItemService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@CommonsLog
public class ItemServiceImpl implements ItemService {
    @Resource
    IItemDao iItemDao;
    @Resource
    IBusinessDao iBusinessDao;
    @Autowired
    protected ModelMapper modelMapper;

    public ItemServiceImpl(IItemDao iItemDao){
        this.iItemDao=iItemDao;
    }
    @Override
    public List<ItemDTO> getBusinessItemList(Integer business_id) {
        List<Item> itemList = iItemDao.findByBusiness_BusinessId(business_id);
        return itemList.stream()
                .map(item -> new ItemDTO(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getBusiness().getBusinessId()))
                .collect(Collectors.toList());
    }
    @Override
    public ItemDTO addItem(Integer business_id, String item_name, Double item_price){
        if(!iItemDao.existsByBusiness_BusinessIdAndItemName(business_id, item_name)){
            Business business = iBusinessDao.findByBusinessId(business_id);
            if(business != null){
                Item newItem = Item.builder()
                        .itemName(item_name)
                        .itemPrice(item_price)
                        .business(business)
                        .build();
                iItemDao.save(newItem);
                return modelMapper.map(newItem, ItemDTO.class);

            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Item findByItemId(Integer item_id) {
        return iItemDao.findByItemId(item_id);
    }


}
