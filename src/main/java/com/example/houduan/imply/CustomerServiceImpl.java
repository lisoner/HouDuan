package com.example.houduan.imply;

import com.example.houduan.dao.ICustomerDao;
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
    public Customer login(String customerName, String password){
        return iCustomerDao.findByCustomerNameAndPassword(customerName, password);
    }
}
