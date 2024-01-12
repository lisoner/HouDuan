package org.example.controller;
import org.example.dto.BusinessDto;
import org.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // 创建商家
    @PostMapping
    public BusinessDto createBusiness(@RequestBody BusinessDto businessDto) {
        return businessService.createBusiness(businessDto);
    }
}