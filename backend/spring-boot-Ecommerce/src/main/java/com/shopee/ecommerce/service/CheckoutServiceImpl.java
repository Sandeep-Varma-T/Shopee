package com.shopee.ecommerce.service;

import com.shopee.ecommerce.Entity.Customer;
import com.shopee.ecommerce.Entity.Order;
import com.shopee.ecommerce.Entity.OrderItem;
import com.shopee.ecommerce.dao.CustomerRepository;
import com.shopee.ecommerce.dto.Purchase;
import com.shopee.ecommerce.dto.PurchaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.addOrderItems(item));

        order.setBillingAddress(purchase.getBillingAddress());

        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        String theEmail = customer.getEmail();
        Customer customerFromDb = customerRepository.findByEmail(theEmail);
        if(customerFromDb != null){
            customer = customerFromDb;
        }
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
