package com.pdp.data.pdpdataservice.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pdp.data.pdpdataservice.pojo.ProductDetails;

@Repository
public class PDPDALImpl implements PDPDAL {

	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public List<ProductDetails> getAllProducts() {
		return mongoTemplate.findAll(ProductDetails.class);
	}

	@Override
	public ProductDetails getPorductById(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		return mongoTemplate.findOne(query, ProductDetails.class);
	}

	@Override
	public ProductDetails addNewProduct(ProductDetails productDetails) {
		mongoTemplate.save(productDetails);
		// Now, user object will contain the ID as well
		return productDetails;
	}

	@Override
	public Object getAllProductSettings(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProductSetting(String productId, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProductSetting(String productId, String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}
