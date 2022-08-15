package com.price.core.interfaces;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;

public interface PriceService {
    PriceResponse getCorePrice(PriceRequest priceRequest);
}
