package com.example.houduan.service;

import com.example.houduan.entity.Business;
import com.example.houduan.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Object login(String customer_name, String password);
}
