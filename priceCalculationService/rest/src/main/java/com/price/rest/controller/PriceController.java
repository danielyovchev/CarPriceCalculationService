package com.price.rest.controller;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.interfaces.PriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/priceCalculation")
    PriceResponse getPrice(@RequestBody PriceRequest priceRequest){
        return priceService.getCorePrice(priceRequest);
    }
}
