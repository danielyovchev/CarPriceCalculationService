package com.price.core.implementation;

import com.price.core.exception.InvalidBoughtCarsException;
import com.price.core.interfaces.GetPriceGroupProcessor;
import org.springframework.stereotype.Service;

@Service
public class GetPriceGroupProcessorCore implements GetPriceGroupProcessor {
    @Override
    public Double priceGroup(Integer count) {
        Double discount = 0.0;
        if(count>0 && count <4){
            discount = 0.01;
        }
        else if(count>4 && count <7){
            discount = 0.02;
        } else if (count>7 && count<10) {
            discount = 0.03;
        } else if (count>10 && count<20) {
            discount = 0.05;
        } else if(count>20){
            discount = 0.1;
        } else if (count<0) {
            throw new InvalidBoughtCarsException();
        }
        return discount;
    }
}
