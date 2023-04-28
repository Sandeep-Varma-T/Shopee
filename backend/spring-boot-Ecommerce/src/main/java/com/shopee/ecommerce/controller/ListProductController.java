package com.shopee.ecommerce.controller;

import com.shopee.ecommerce.Entity.Product;
import com.shopee.ecommerce.dto.ProductListingResponse;
import com.shopee.ecommerce.service.AddProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/list-product")
public class ListProductController {

    private AddProductService addProductService;

    public ListProductController(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @PostMapping("/add-product")
    public ProductListingResponse addNewProduct(@RequestBody Product product){

        ProductListingResponse theResponse = addProductService.addNewProduct(product);
        return theResponse;
    }
}
