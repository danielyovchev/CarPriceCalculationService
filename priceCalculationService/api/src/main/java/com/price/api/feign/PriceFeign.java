package com.price.api.feign;

import com.price.api.model.PriceRequest;
import com.price.api.model.PriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PriceFeignClient", url = "http://localhost:8084")
public interface PriceFeign {
    @PostMapping("/priceCalculation")
    PriceResponse getPrice(@RequestBody PriceRequest priceRequest);
}
