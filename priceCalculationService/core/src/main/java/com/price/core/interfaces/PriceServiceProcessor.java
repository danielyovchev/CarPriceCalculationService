package com.price.core.interfaces;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;

public interface PriceServiceProcessor {
    PriceResponse getCorePrice(PriceRequest priceRequest);
}
