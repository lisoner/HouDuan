package com.example.houduan.service;


import com.example.houduan.entity.Business;
import org.springframework.stereotype.Service;

@Service
public interface BusinessService {
    Business login(String business_name, String password);
}
