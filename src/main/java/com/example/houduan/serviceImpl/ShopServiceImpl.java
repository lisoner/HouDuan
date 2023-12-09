package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IShopDao;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.ShopService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
public class ShopServiceImpl implements ShopService {
    @Resource
    IShopDao iShopDao;
    @Resource
    IBusinessDao iBusinessDao;

    public ShopServiceImpl(IShopDao iShopDao){
        this.iShopDao = iShopDao;
    }

    @Override
    public List<Shop> getAllShopList() {
        return iShopDao.findAllByIsDeletedIsNull();
    }

    @Override
    public List<Shop> getBusinessShopList(Integer business_id) {
        return iShopDao.findShopsByBusiness_BusinessIdAndIsDeletedIsNull(business_id);
    }

    @Override
    public Shop addShop(Integer business_id, String shop_name){
        /*查询是否已经存在name相同的shop*/
        if(!iShopDao.existsByShopName(shop_name)){
            /*获取商家对象*/
            Business business = iBusinessDao.findByBusinessId(business_id);
            /*如果商家存在，创建新的店铺*/
            if(business != null){
                Shop newShop = Shop.builder()
                        .shopName(shop_name)
                        .business(business)
                        .build();

                return iShopDao.save(newShop);
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Shop deleteShop(String shop_name) {
        Shop shop = iShopDao.findByShopName(shop_name);
        if (shop != null) {
            shop.setIsDeleted(1);
            iShopDao.save(shop);
        }
        return shop;
    }
}
