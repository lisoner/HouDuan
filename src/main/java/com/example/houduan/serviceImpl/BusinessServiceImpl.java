package com.example.houduan.serviceImpl;


import com.example.houduan.Controller.BusinessController;
import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.service.BusinessService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Object login(String businessName, String password) {
        Business business = ibusinessDao.findByBusinessNameAndPassword(businessName, password);
        if (business != null) {
            BusinessInfoDTO businessInfoDTO = new BusinessInfoDTO();
            businessInfoDTO.setBusinessId(business.getBusinessId());
            businessInfoDTO.setBusinessName(businessName);
            businessInfoDTO.setMessage("Login successful");
            return businessInfoDTO;
        } else {
            return null;
        }
    }
}
