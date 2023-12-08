package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IItemDao;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Item;
import com.example.houduan.service.ItemService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
public class ItemServiceImpl implements ItemService {
    @Resource
    IItemDao iItemDao;
    @Resource
    IBusinessDao iBusinessDao;

    public ItemServiceImpl(IItemDao iItemDao){
        this.iItemDao=iItemDao;
    }
    @Override
    public List<Item> getBusinessItemList(Integer business_id) {
        return iItemDao.findByBusiness_BusinessId(business_id);
    }
    @Override
    public Item addItem(Integer business_id, String item_name, Double item_price){
        if(!iItemDao.existsByBusiness_BusinessIdAndItemName(business_id, item_name)){
            Business business = iBusinessDao.findByBusinessId(business_id);
            if(business != null){
                Item newItem = Item.builder()
                        .itemName(item_name)
                        .itemPrice(item_price)
                        .business(business)
                        .build();

                return iItemDao.save(newItem);
            }else {
                return null;
            }
        }
        return null;
    }
}
