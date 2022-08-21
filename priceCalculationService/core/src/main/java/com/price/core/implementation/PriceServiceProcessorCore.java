package com.price.core.implementation;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.exception.InvalidOperationException;
import com.price.core.interfaces.GetPriceGroupProcessor;
import com.price.core.interfaces.PriceServiceProcessor;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceProcessorCore implements PriceServiceProcessor {
    //calculating car price by getting the discount for the customer and depending on the deal type
    private final GetPriceGroupProcessor getPriceGroupProcessor;

    public PriceServiceProcessorCore(GetPriceGroupProcessor getPriceGroupProcessor) {
        this.getPriceGroupProcessor = getPriceGroupProcessor;
    }

    @Override
    public PriceResponse getCorePrice(PriceRequest priceRequest) {
        Double price = priceRequest.getBasePrice();
        final Double discount = getPriceGroupProcessor.priceGroup(priceRequest.getCustomerPurchasedCars());
        final String type = priceRequest.getType();
        String message = "";
        try{
            if(type.equals("leasing")){
                Integer months = priceRequest.getMonths();
                double interest = priceRequest.getMonths()*20;
                price = price - price*discount+interest;
                message = "Leasing for "+priceRequest.getMonths()+" with average installment: "+price/priceRequest.getMonths()
                        +". Total price: "+price;
            }
            else if(type.equals("cash")){
                price -= price*discount;
                message = "Car bought cash. Total price: "+price;
            }
            else {
                throw new InvalidOperationException();
            }
            return PriceResponse.builder().price(price).message(message).build();
            }
        catch (Exception e){
            throw new InvalidOperationException();
        }
    }
}
