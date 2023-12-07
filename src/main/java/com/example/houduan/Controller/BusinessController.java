package com.example.houduan.Controller;

import com.example.houduan.entity.Business;
import com.example.houduan.service.BusinessService;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/businessLogin")
public class BusinessController {
    @Resource
    BusinessService businessService;
    @Autowired
    public BusinessController(BusinessService businessService){
        this.businessService = businessService;
    }

    /*这里是Login部分*/
    @PostMapping
    public ResponseEntity<Object> login(@RequestParam String business_name, @RequestParam String password){
        Business business = businessService.login(business_name, password);
        if (business != null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setBusiness_id(business.getBusinessId());
            loginResponse.setBusiness_name(business_name);
            loginResponse.setMessage("Login successful");
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
    @Data
    public class LoginResponse{
        private Integer business_id;
        private String business_name;
        private String message;
    }

}
