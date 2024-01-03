package com.example.houduan.serviceImpl;

import com.example.houduan.dao.ICustomerDao;
import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.dto.CustomerInfoDTO;
import com.example.houduan.entity.Business;
import com.example.houduan.entity.Customer;
import com.example.houduan.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class CustomerServiceImpl implements CustomerService {
    @Resource
    ICustomerDao iCustomerDao;
    @Autowired
    protected ModelMapper modelMapper;

    public CustomerServiceImpl(ICustomerDao iCustomerDao){
        this.iCustomerDao = iCustomerDao;
    }

    @Override
    public CustomerInfoDTO login(String customerName, String password){
        Customer customer = iCustomerDao.findByCustomerNameAndPassword(customerName, password);
        if (customer != null) {
            CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
            customerInfoDTO.setCustomerId(customer.getCustomerId());
            customerInfoDTO.setCustomerName(customerName);
            return customerInfoDTO;
        } else {
            return null;
        }
    }

    @Override
    public CustomerInfoDTO findCustomerByCustomerName(String customer_name) {
        return modelMapper.map(iCustomerDao.findCustomerByCustomerName(customer_name), CustomerInfoDTO.class);
    }

    @Override
    public Customer findByCustomerId(Integer customer_id) {
        return iCustomerDao.findByCustomerId(customer_id);
    }

    @Override
    public CustomerInfoDTO save(String customer_name, String password) {
        Customer customer = Customer.builder()
                .customerName(customer_name)
                .password(password)
                .build();
        Customer tempCustomer = iCustomerDao.save(customer);
        return modelMapper.map(tempCustomer, CustomerInfoDTO.class);
    }
}
