package com.logoc.pdplogicservice.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logoc.pdplogicservice.pojo.ProductDetails;

@RestController
@RequestMapping("/pdp")
@CrossOrigin(origins= {"http://localhost:3000"})
public class MovieResource {
	@RequestMapping("/{catentryId}")
	@CrossOrigin(origins= {"http://localhost:3000"})
	public ProductDetails getMovie(@PathVariable("catentryId") String catentryId) {
		
		ProductDetails pdetails=new ProductDetails();
		pdetails.setProductName("Wearever Cami");
		pdetails.setRating(4);
		pdetails.setPrice(39);
		pdetails.setProductId(Long.valueOf(catentryId));
		
		List size=new ArrayList();
		size.add("XS");
		size.add("S");
		size.add("M");
		size.add("L");
		size.add("XL");
		pdetails.setAttrName1("SIZE");
		pdetails.setAttributes1(size);
		
		List sizeType=new ArrayList();
		sizeType.add("MISSES");
		sizeType.add("PETITE");
		sizeType.add("WOMANS");
		pdetails.setAttrName2("SIZE TYPE");
		pdetails.setAttributes2(sizeType);
		
		List color=new ArrayList();
		color.add("black");
		color.add("gray");
		color.add("white");
		pdetails.setAttrName3("COLOR");
		pdetails.setAttributes3(color);
		
		pdetails.setImg1("https://s7.jjill.com/is/image/JJill/114131_AZY?$pdp_main2$");
		pdetails.setImg2("https://s7.jjill.com/is/image/JJill/114131_SIDE?$pdp_thumb2$");
		pdetails.setImg3("https://s7.jjill.com/is/image/JJill/114131_BACK?$pdp_thumb2$");
		pdetails.setImg4("https://s7.jjill.com/is/image/JJill/114131_ALT1?$pdp_thumb2$");
		
		
		return pdetails;
		
	}

}
