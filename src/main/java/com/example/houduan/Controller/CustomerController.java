package com.example.houduan.Controller;

import com.example.houduan.entity.Customer;
import com.example.houduan.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customerLogin")
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

/*这里是Login部分*/

    @PostMapping
    public ResponseEntity<Object> login(@RequestParam String customer_name, @RequestParam String password){
        Customer customer = customerService.login(customer_name, password);
        if (customer != null) {
            CustomerController.LoginResponse loginResponse = new CustomerController.LoginResponse();
            loginResponse.setCustomer_id(customer.getCustomerId());
            loginResponse.setCustomer_name(customer_name);
            loginResponse.setMessage("Login successful");
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
    @Data
    public class LoginResponse{
        private int customer_id;
        private String customer_name;
        private String message;
    }
}
