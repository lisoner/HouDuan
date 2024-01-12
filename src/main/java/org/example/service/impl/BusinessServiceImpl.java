package org.example.service.impl;

import org.example.dao.BusinessDao;
import org.example.dto.BusinessDto;
import org.example.entity.Business;
import org.example.service.BusinessService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessDao businessDao;

    public BusinessServiceImpl(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    @Override
    public BusinessDto createBusiness(BusinessDto businessDto) {
        Business business = new Business();
        BeanUtils.copyProperties(businessDto, business);
        business = businessDao.save(business);
        BeanUtils.copyProperties(business, businessDto);
        return businessDto;
    }

    @Override
    public List<BusinessDto> getAllBusinesses() {
        List<Business> businesses = businessDao.findAll();
        return businesses.stream()
                .map(business -> {
                    BusinessDto businessDto = new BusinessDto();
                    BeanUtils.copyProperties(business, businessDto);
                    return businessDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BusinessDto getBusinessById(Long businessId) {
        Business business = businessDao.findById(businessId).orElse(null);
        if (business != null) {
            BusinessDto businessDto = new BusinessDto();
            BeanUtils.copyProperties(business, businessDto);
            return businessDto;
        }
        return null;
    }

    @Override
    public BusinessDto login(String name, String password) {
        Business business = businessDao.findByNameAndPassword(name, password);
        if (business != null) {
            BusinessDto businessDto = new BusinessDto();
            BeanUtils.copyProperties(business, businessDto);
            return businessDto;
        }
        return null;
    }
}
