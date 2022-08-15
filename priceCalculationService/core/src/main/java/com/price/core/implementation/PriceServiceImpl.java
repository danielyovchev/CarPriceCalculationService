package com.price.core.implementation;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.exception.InvalidOperationException;
import com.price.core.interfaces.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public PriceResponse getCorePrice(PriceRequest priceRequest) {
        Double price = priceRequest.getBasePrice();
        final String type = priceRequest.getType();
        if(type.equals("leasing")){
            price += priceRequest.getMonths()*20;
        }
        else if(type.equals("cash")){
            
        }
        else {
            throw new InvalidOperationException();
        }
        return PriceResponse.builder().price(price).build();
    }
}
