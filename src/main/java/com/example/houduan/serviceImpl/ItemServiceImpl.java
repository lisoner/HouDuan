package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IItemDao;
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
}
