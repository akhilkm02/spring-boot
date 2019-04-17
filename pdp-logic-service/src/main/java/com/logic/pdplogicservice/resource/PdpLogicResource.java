package com.logic.pdplogicservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logic.pdplogicservice.pojo.ProductDetails;
import com.logic.pdplogicservice.proxy.PDPDataClient;

@RestController
@RequestMapping("/product")
public class PdpLogicResource {

	@Autowired
	private PDPDataClient client;

	@GetMapping(value = "/{productId}")
	public ProductDetails getProductDetails(@PathVariable("productId") String productId) {
		ProductDetails pdetails = client.getProductDetails(productId);

		return pdetails;
	}

}
