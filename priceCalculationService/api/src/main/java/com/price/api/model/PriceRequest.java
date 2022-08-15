package com.price.api.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE) @Builder
public class PriceRequest {
    private String type;
    private Double basePrice;
    private Integer customerPurchasedCars;
    private Integer months;
}
