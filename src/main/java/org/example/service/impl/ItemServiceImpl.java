package org.example.service.impl;

import org.example.dao.ItemDao;
import org.example.dto.ItemDto;
import org.example.entity.Item;
import org.example.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDto, item);
        item = itemDao.save(item);
        BeanUtils.copyProperties(item, itemDto);
        return itemDto;
    }
}
