package org.example.dao;

import org.example.entity.Item;
import org.example.entity.LineItem;
import org.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemDao extends JpaRepository<LineItem, Long> {
    LineItem findByOrderAndItem(Order order, Item item);

    // Additional line item-related queries if needed
}
