package com.price.core.implementation;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.exception.InvalidOperationException;
import com.price.core.interfaces.GetPriceGroupService;
import com.price.core.interfaces.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    private final GetPriceGroupService getPriceGroupService;

    public PriceServiceImpl(GetPriceGroupService getPriceGroupService) {
        this.getPriceGroupService = getPriceGroupService;
    }

    @Override
    public PriceResponse getCorePrice(PriceRequest priceRequest) {
        Double price = priceRequest.getBasePrice();
        Double discount = getPriceGroupService.priceGroup(priceRequest.getCustomerPurchasedCars());
        final String type = priceRequest.getType();
        String message = "";
        try{
        if(type.equals("leasing")){
            Integer months = priceRequest.getMonths();
            if(months == null) {
                months = 60;
            }
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
