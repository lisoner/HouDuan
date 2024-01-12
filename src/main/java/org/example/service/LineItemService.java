package org.example.service;

import org.example.dto.LineItemDto;

import java.util.List;

public interface LineItemService {
    List<LineItemDto> createLineItems(Long orderId, Long shopId, List<Long> itemIds);

    LineItemDto createLineItem(Long customerId, Long shopId, List<Long> itemIds);

}
