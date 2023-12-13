package com.example.houduan.dao;

import com.example.houduan.entity.Business;
import com.example.houduan.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerName(String customer_name);
    Customer findByCustomerNameAndPassword(String customer_name, String password);
    Customer findByCustomerId(Integer customer_id);
}
