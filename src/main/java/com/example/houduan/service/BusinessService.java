package com.example.houduan.service;


import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.entity.Business;
import org.springframework.stereotype.Service;

@Service
public interface BusinessService {
    BusinessInfoDTO login(String business_name, String password);
    BusinessInfoDTO findByBusinessName(String business_name);
    Business findByBusinessId(Integer business_id);
}
