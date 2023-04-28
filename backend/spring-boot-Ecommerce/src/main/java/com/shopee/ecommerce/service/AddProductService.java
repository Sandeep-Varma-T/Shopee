package com.shopee.ecommerce.service;

import com.shopee.ecommerce.Entity.Product;
import com.shopee.ecommerce.dto.ProductListingResponse;
import com.shopee.ecommerce.dto.PurchaseResponse;

public interface AddProductService {

    ProductListingResponse addNewProduct(Product product);

}
