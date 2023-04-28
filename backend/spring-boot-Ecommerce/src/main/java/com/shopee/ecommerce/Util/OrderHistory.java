package com.shopee.ecommerce.Util;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrderHistory {

    private Long id;
    private String order_tracking_number;
    private BigDecimal total_price;
    private BigDecimal total_quantity;
    private String city;
    private String country;
    private String state;
    private String street;
    private String zip_code;
    private Date date_created;
    private String image_url;
    private String email;

}
