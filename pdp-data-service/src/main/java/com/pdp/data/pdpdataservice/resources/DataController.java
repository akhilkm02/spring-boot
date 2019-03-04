package com.pdp.data.pdpdataservice.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pdp.data.pdpdataservice.dal.PDPDAL;
import com.pdp.data.pdpdataservice.dal.PDPRepository;
import com.pdp.data.pdpdataservice.pojo.ProductDetails;

@RestController
@RequestMapping(value = "/")
public class DataController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final PDPRepository pdpRepository;

	private final PDPDAL pdpDAL;

	public DataController(PDPRepository pdpRepository, PDPDAL pdpDAL) {
		this.pdpRepository = pdpRepository;
		this.pdpDAL = pdpDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ProductDetails addNewProduct(@RequestBody ProductDetails productDetails) {
		return pdpRepository.save(productDetails);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ProductDetails> getAllUsers() {
		LOG.info("Getting all users.");
		return pdpRepository.findAll();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ProductDetails getUser(@PathVariable String productId) {

		return pdpRepository.findOne(productId);
	}


/*
	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
		User user = userRepository.findOne(userId);
		if (user != null) {
			return userDAL.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}*/


/*	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		return userDAL.getUserSetting(userId, key);
	}*/

/*	@RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		User user = userRepository.findOne(userId);
		if (user != null) {
			user.getUserSettings().put(key, value);
			userRepository.save(user);
			return "Key added";
		} else {
			return "User not found.";
		}
	}*/
}