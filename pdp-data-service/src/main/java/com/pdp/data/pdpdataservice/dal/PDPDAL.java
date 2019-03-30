package com.pdp.data.pdpdataservice.dal;

import java.util.List;

import com.pdp.data.pdpdataservice.pojo.ProductDetails;

public interface PDPDAL {

	List<ProductDetails> getAllProducts();

	ProductDetails getPorductById(String productId);

	ProductDetails addNewProduct(ProductDetails productDetails);

	Object getAllProductSettings(String productId);

	String getProductSetting(String productId, String key);

	String addProductSetting(String productId, String key, String value);
}