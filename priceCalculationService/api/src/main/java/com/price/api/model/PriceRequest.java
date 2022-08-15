package com.price.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PriceRequest {
    private String type;
    private Double basePrice;
    private Integer customerPurchasedCars;
    private Integer months;
}
