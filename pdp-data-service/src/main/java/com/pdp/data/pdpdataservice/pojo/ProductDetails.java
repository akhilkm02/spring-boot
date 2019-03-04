
package com.pdp.data.pdpdataservice.pojo;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductDetails {
	
 @Id	
 private String productId;
 private String productName;
 private int rating;
 private float price;
 private List attributes1;
 private List attributes2;
 private List attributes3;
 private String attrName1;
 private String attrName2;
 private String attrName3;
 private String img1;
 private String img2;
 private String img3;
 private String img4;
 
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}


public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public List getAttributes1() {
	return attributes1;
}
public void setAttributes1(List attributes1) {
	this.attributes1 = attributes1;
}
public List getAttributes2() {
	return attributes2;
}
public void setAttributes2(List attributes2) {
	this.attributes2 = attributes2;
}
public List getAttributes3() {
	return attributes3;
}
public void setAttributes3(List attributes3) {
	this.attributes3 = attributes3;
}
public String getAttrName1() {
	return attrName1;
}
public void setAttrName1(String attrName1) {
	this.attrName1 = attrName1;
}
public String getAttrName2() {
	return attrName2;
}
public void setAttrName2(String attrName2) {
	this.attrName2 = attrName2;
}
public String getAttrName3() {
	return attrName3;
}
public void setAttrName3(String attrName3) {
	this.attrName3 = attrName3;
}
public String getImg1() {
	return img1;
}
public void setImg1(String img1) {
	this.img1 = img1;
}
public String getImg2() {
	return img2;
}
public void setImg2(String img2) {
	this.img2 = img2;
}
public String getImg3() {
	return img3;
}
public void setImg3(String img3) {
	this.img3 = img3;
}
public String getImg4() {
	return img4;
}
public void setImg4(String img4) {
	this.img4 = img4;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}

}
