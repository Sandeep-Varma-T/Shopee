package com.shopee.ecommerce.dto;

import com.shopee.ecommerce.Entity.Address;
import com.shopee.ecommerce.Entity.Customer;
import com.shopee.ecommerce.Entity.Order;
import com.shopee.ecommerce.Entity.OrderItem;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
