package com.example.houduan.serviceImpl;

import com.example.houduan.dao.ICustomerDao;
import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.dto.CustomerInfoDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Customer;
import com.example.houduan.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class CustomerServiceImpl implements CustomerService {
    @Resource
    ICustomerDao iCustomerDao;

    public CustomerServiceImpl(ICustomerDao iCustomerDao){
        this.iCustomerDao = iCustomerDao;
    }

    @Override
    public Object login(String customerName, String password){
        Customer customer = iCustomerDao.findByCustomerNameAndPassword(customerName, password);
        if (customer != null) {
            CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
            customerInfoDTO.setCustomerId(customer.getCustomerId());
            customerInfoDTO.setCustomerName(customerName);
            customerInfoDTO.setMessage("Login successful");
            return customerInfoDTO;
        } else {
            return null;
        }
    }
}
