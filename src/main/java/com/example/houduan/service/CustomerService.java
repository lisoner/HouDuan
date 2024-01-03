package com.example.houduan.service;

import com.example.houduan.dto.CustomerInfoDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerInfoDTO login(String customer_name, String password);
    CustomerInfoDTO findCustomerByCustomerName(String customer_name);
    Customer findByCustomerId(Integer customer_id);
}
