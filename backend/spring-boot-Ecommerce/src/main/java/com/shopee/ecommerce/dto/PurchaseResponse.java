package com.shopee.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class PurchaseResponse {

    @NonNull
    private String orderTrackingNumber;

}
