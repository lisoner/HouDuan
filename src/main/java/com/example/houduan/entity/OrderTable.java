package com.example.houduan.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer orderState;/*0未支付，1已支付，2顾客取消，3商家已确认，4商家退款*/
    private Double orderCost=0.0;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "shopId", referencedColumnName = "shopId"),
            @JoinColumn(name = "shopName", referencedColumnName = "shopName"),
    })
    private Shop shop;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "customerId", referencedColumnName = "customerId"),
            @JoinColumn(name = "customerName", referencedColumnName = "customerName"),
    })
    private Customer customer;

}
