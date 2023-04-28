package com.shopee.ecommerce.service;

import com.shopee.ecommerce.dto.Purchase;
import com.shopee.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
