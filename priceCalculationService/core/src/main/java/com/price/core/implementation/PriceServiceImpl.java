package com.price.core.implementation;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.interfaces.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public PriceResponse getCorePrice(PriceRequest priceRequest) {

        return null;
    }
}
