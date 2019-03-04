Steps to start:-

1. Please install Mongo DB with Compass
2. Create a DB entry
   a. open postman 
   http://localhost:3011/pdp/create  (POST)
   {  
   "productName":"Wearever Cami",
   "productId":1000,
   "rating":5,
   "price":59.0,
   "attributes1":[  
      "S",
      "M",
      "M",
      "L"
    ],
   "attributes2":[  
      "GIRL",
      "NICE GIRL",
      "WOMANS"
   ],
   "attributes3":[  
      "black",
      "red",
      "white"
   ],
   "attrName1":"SIZE",
   "attrName2":"SIZE TYPE",
   "attrName3":"COLOR",
   "img1":"https://s7.jjill.com/is/image/JJill/159481_2JW?$pdp_thumb2$",
   "img2":"https://s7.jjill.com/is/image/JJill/159481_SIDE?$pdp_thumb2$",
   "img3":"https://s7.jjill.com/is/image/JJill/159481_BACK?$pdp_thumb2$",
   "img4":"https://s7.jjill.com/is/image/JJill/159481_BACK?$pdp_thumb2$"
  }
3. Start the react js
   go to the path https://github.com/akhilkm02/spring-boot/tree/workspace/pdp-ui-service/frontend  --> npm start
4. Start pdp-data-service, pdp-logic-service

Hit the below url http://localhost:3000/1000 :)   
  