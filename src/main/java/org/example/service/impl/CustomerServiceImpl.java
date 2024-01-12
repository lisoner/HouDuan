package org.example.service.impl;

import org.example.dao.CustomerDao;
import org.example.dao.OrderDao;
import org.example.dto.CustomerDto;
import org.example.dto.LineItemDto;
import org.example.dto.OrderDto;
import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    private final OrderDao orderDao;

    public CustomerServiceImpl(CustomerDao customerDao, OrderDao orderDao) {
        this.customerDao = customerDao;
        this.orderDao = orderDao;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer = customerDao.save(customer);
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    @Override
    public CustomerDto login(String name, String password) {
        Customer customer = customerDao.findByNameAndPassword(name, password);
        if (customer != null) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            return customerDto;
        }
        return null;
    }

    @Override
    public OrderDto createOrder(Long customerId, List<LineItemDto> lineItems) {

        return null;
    }

    @Override
    public OrderDto payOrder(Long customerId, Long orderId) {

        return null;
    }

}