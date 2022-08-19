package com.price.rest.controller;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import com.price.core.interfaces.PriceServiceProcessor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PriceController {
    private final PriceServiceProcessor priceServiceProcessor;

    public PriceController(PriceServiceProcessor priceServiceProcessor) {
        this.priceServiceProcessor = priceServiceProcessor;
    }

    @PostMapping("/priceCalculation")
    PriceResponse getPrice(@Valid @RequestBody PriceRequest priceRequest){
        return priceServiceProcessor.getCorePrice(priceRequest);
    }
}
