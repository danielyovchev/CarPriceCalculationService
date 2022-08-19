package com.price.api.model;

import lombok.*;

@Getter @Setter(AccessLevel.PRIVATE) @Builder
public class PriceRequest {
    private String type;
    private Double basePrice;
    private Integer customerPurchasedCars;
    @NonNull
    private Integer months;
}
