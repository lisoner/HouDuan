package org.example.service;

import org.example.dto.BusinessDto;

import java.util.List;

public interface BusinessService {
    BusinessDto createBusiness(BusinessDto businessDto);
    List<BusinessDto> getAllBusinesses();
    BusinessDto getBusinessById(Long businessId);
    BusinessDto login(String name, String password);
}
