package com.shopee.ecommerce.controller;

import com.shopee.ecommerce.dto.Purchase;
import com.shopee.ecommerce.dto.PurchaseResponse;
import com.shopee.ecommerce.service.CheckoutService;
import com.shopee.ecommerce.service.CheckoutServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

    private CheckoutService checkoutService;

    public CheckOutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
