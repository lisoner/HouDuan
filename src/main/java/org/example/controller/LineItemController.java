package org.example.controller;

import org.example.service.LineItemService;
import org.example.dto.LineItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lineItems")
public class LineItemController {

    private final LineItemService lineItemService;

    @Autowired
    public LineItemController(LineItemService lineItemService) {
        this.lineItemService = lineItemService;
    }

    // 顾客挑选商品创建订单项
    @PostMapping("/customer/{customerId}/shop/{shopId}")
    public LineItemDto createLineItem(@PathVariable Long customerId, @PathVariable Long shopId, @RequestBody List<Long> itemIds) {
        return lineItemService.createLineItem(customerId, shopId, itemIds);
    }
}
