package com.example.houduan.Controller;

import com.example.houduan.entity.Business;
import com.example.houduan.service.BusinessService;
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
@RequestMapping("/businessLogin")
@Tag(name = "Business", description = "BusinessController")
public class BusinessController {
    @Resource
    BusinessService businessService;
    @Autowired
    public BusinessController(BusinessService businessService){
        this.businessService = businessService;
    }

    /*这里是Login部分*/
    @Operation(summary = "商家登录",description = "商家登录")
    @PostMapping
    public ResponseEntity<Object> login(@RequestParam String business_name, @RequestParam String password){
        return new ResponseEntity<>(businessService.login(business_name, password), HttpStatus.OK);
    }

}
