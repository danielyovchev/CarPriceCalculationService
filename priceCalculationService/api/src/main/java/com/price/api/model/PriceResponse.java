package com.price.api.model;

import lombok.*;

@Getter @Setter(AccessLevel.PACKAGE) @Builder @EqualsAndHashCode
public class PriceResponse {
    private Double price;
    private String message;
}
