package com.pdp.data.pdpdataservice.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdp.data.pdpdataservice.dal.PDPRepository;
import com.pdp.data.pdpdataservice.pojo.ProductDetails;

@RestController
@RequestMapping(value = "/product")
public class DataController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PDPRepository pdpRepository;

	@PostMapping(value = "")
	public ProductDetails addNewProduct(@RequestBody ProductDetails productDetails) {
		return pdpRepository.save(productDetails);
	}

	@GetMapping(value = "")
	public List<ProductDetails> getAllProducts() {
		LOG.info("Fetching all products.");
		return pdpRepository.findAll();
	}

	@GetMapping(value = "/{productId}")
	public Optional<ProductDetails> getUser(@PathVariable String productId) {
		return pdpRepository.findById(productId);
	}

}