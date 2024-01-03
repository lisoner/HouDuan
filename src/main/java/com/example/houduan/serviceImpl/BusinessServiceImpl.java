package com.example.houduan.serviceImpl;


import com.example.houduan.Controller.BusinessController;
import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.service.BusinessService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@CommonsLog
public class BusinessServiceImpl implements BusinessService {
    @Resource
    IBusinessDao ibusinessDao;
    @Autowired
    protected ModelMapper modelMapper;

    public BusinessServiceImpl(IBusinessDao ibusinessDao){
        this.ibusinessDao=ibusinessDao;
    }

    @Override
    public BusinessInfoDTO login(String businessName, String password) {
        Business business = ibusinessDao.findByBusinessNameAndPassword(businessName, password);
        if (business != null) {
            BusinessInfoDTO businessInfoDTO = new BusinessInfoDTO();
            businessInfoDTO.setBusinessId(business.getBusinessId());
            businessInfoDTO.setBusinessName(business.getBusinessName());
            return businessInfoDTO;
        } else {
            return null;
        }
    }

    @Override
    public BusinessInfoDTO findByBusinessName(String business_name) {
        return modelMapper.map(ibusinessDao.findByBusinessName(business_name), BusinessInfoDTO.class);
    }

    @Override
    public Business findByBusinessId(Integer business_id) {
        return ibusinessDao.findByBusinessId(business_id);
    }

    @Override
    public BusinessInfoDTO save(String business_name, String password) {
        Business business = Business.builder()
                .businessName(business_name)
                .password(password)
                .build();
        Business tempBusiness = ibusinessDao.save(business);
        return modelMapper.map(tempBusiness, BusinessInfoDTO.class);
    }
}
