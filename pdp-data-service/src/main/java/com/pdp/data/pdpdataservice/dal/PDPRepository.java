package com.pdp.data.pdpdataservice.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pdp.data.pdpdataservice.pojo.ProductDetails;

@Repository
public interface PDPRepository extends MongoRepository<ProductDetails, String> {
}
