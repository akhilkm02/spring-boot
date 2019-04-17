package com.logic.pdplogicservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.logic.pdplogicservice.pojo.ProductDetails;

@FeignClient(name = "pdp-data-service", url = "localhost:3013")
public interface PDPDataClient {

	@GetMapping("/product/{productId}")
	public ProductDetails getProductDetails(@PathVariable(name = "productId") String productId);
}
