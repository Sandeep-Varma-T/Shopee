package com.shopee.ecommerce.service;

import com.shopee.ecommerce.Entity.Product;
import com.shopee.ecommerce.Entity.ProductCategory;
import com.shopee.ecommerce.dao.ProductRepository;
import com.shopee.ecommerce.dto.ProductListingResponse;
import com.shopee.ecommerce.dto.PurchaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddProductServiceImpl implements AddProductService{

    ProductRepository productRepository;
    public AddProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductListingResponse addNewProduct(Product product) {

        ProductCategory category = product.getCategory();
        int category_id = (int)((long) category.getId());
        String sku = productRepository.findOneBySku(category_id);
        String imgUrl = product.getImageUrl();

        switch(category_id){
            case 1 :
                sku = "BOOK-TECH-"+(Integer.valueOf(sku.split("TECH-")[1]) + 1);
                imgUrl = "assets/images/products/books/"+imgUrl;
                break;
            case 2 :
                sku = "COFFEEMUG-"+(Integer.valueOf(sku.split("-")[1]) + 1);
                imgUrl = "assets/images/products/coffeemugs/"+imgUrl;
                break;
            case 3:
                sku = "MOUSEPAD-"+(Integer.valueOf(sku.split("-")[1]) + 1);
                imgUrl = "assets/images/products/mousepad/"+imgUrl;
                break;
            case 4:
                sku = "LUGGAGETAG-"+(Integer.valueOf(sku.split("-")[1]) + 1);
                imgUrl = "assets/images/products/luggagetag/"+imgUrl;
                break;
        }

        product.setSku(sku);
        product.setImageUrl(imgUrl);
        productRepository.save(product);

        return new ProductListingResponse("Success");
    }
}
