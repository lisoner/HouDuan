package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IShopDao;
import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.dto.ShopDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.BusinessService;
import com.example.houduan.service.ShopService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@CommonsLog
public class ShopServiceImpl implements ShopService {
    @Resource
    IShopDao iShopDao;
    @Resource
    BusinessService businessService;
    @Autowired
    protected ModelMapper modelMapper;

    public ShopServiceImpl(IShopDao iShopDao){
        this.iShopDao = iShopDao;
    }

    @Override
    public List<ShopDTO> getAllShopList() {
        List<Shop> shopList = iShopDao.findAll();
        List<ShopDTO> shopDTOList = new ArrayList<>();
        for(Shop shop : shopList){
            ShopDTO shopDTO = modelMapper.map(shop, ShopDTO.class);
            shopDTOList.add(shopDTO);
        }
        return shopDTOList;
    }

    @Override
    public List<ShopDTO> findShopsByBusiness_BusinessIdAndIsDeletedIsNull(Integer business_id) {
        List<Shop> shopList = iShopDao.findShopsByBusiness_BusinessIdAndIsDeletedIsNull(business_id);
        List<ShopDTO> shopDTOList = new ArrayList<>();
        for(Shop shop : shopList){
            ShopDTO shopDTO = modelMapper.map(shop, ShopDTO.class);
            shopDTOList.add(shopDTO);
        }
        return shopDTOList;
    }

    @Override
    public ShopDTO addShop(Integer business_id, String shop_name){
        /*查询是否已经存在name相同的shop*/
        if(!iShopDao.existsByShopName(shop_name)){
            /*获取商家对象*/
            Business business = businessService.findByBusinessId(business_id);
            /*如果商家存在，创建新的店铺*/
            if(business != null){
                Shop newShop = Shop.builder()
                        .shopName(shop_name)
                        .business(business)
                        .build();
                iShopDao.save(newShop);
                return modelMapper.map(newShop,ShopDTO.class);
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public ShopDTO deleteShop(String shop_name) {
        Shop shop = iShopDao.findByShopName(shop_name);
        if (shop != null) {
            shop.setIsDeleted(1);
            iShopDao.save(shop);
        }

        return modelMapper.map(shop, ShopDTO.class);
    }

    @Override
    public Shop findByShopId(Integer shop_id) {
        return iShopDao.findByShopId(shop_id);
    }


}
