package com.example.houduan.Controller;

import com.example.houduan.dto.BusinessInfoDTO;
import com.example.houduan.dto.CustomerInfoDTO;
import com.example.houduan.entity.Customer;
import com.example.houduan.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "Customer", description = "CustomerController")
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

/*这里是Login部分*/

    @Operation(summary = "顾客登录",description = "顾客登录")
    @PostMapping("/customerLogin")
    public ResponseEntity<Object> login(@RequestParam String customer_name, @RequestParam String password){
        return new ResponseEntity<>(customerService.login(customer_name, password), HttpStatus.OK);
    }

    @Operation(summary = "顾客注册",description = "顾客注册")
    @PostMapping("/customerRegister")
    public CustomerInfoDTO save(@RequestParam String customer_name, @RequestParam String password){
        return customerService.save(customer_name, password);
    }
}
