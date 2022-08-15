package com.price.api.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PACKAGE) @Builder
public class PriceResponse {
    private Double price;
}
