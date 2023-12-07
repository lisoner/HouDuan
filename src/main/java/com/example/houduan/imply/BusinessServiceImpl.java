package com.example.houduan.imply;


import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.entity.Business;
import com.example.houduan.service.BusinessService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class BusinessServiceImpl implements BusinessService {
    @Resource
    IBusinessDao ibusinessDao;

    public BusinessServiceImpl(IBusinessDao ibusinessDao){
        this.ibusinessDao=ibusinessDao;
    }

    @Override
    public Business login(String businessName, String password) {
        return ibusinessDao.findByBusinessNameAndPassword(businessName, password);
    }
}
