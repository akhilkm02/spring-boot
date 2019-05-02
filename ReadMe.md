Steps to start:-

1. Please install Mongo DB with Compass

2. Create a DB entry

   a) open postman 
   
   
   http://localhost:3013/pdp/create  (POST)
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
  
4. Start discovery-server,zuul-api-gateway,pdp-data-service, pdp-logic-service,pdp-logic-service

Hit the below url http://localhost:3010/1000 :)   

WebSocket with rabbitmq:-
--------------------------

1. Install otp_win64_21.3.exe,rabbitmq-server-3.7.14.exe
2. Navigate to C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14\sbin
3. run the following commands
   
   a) rabbitmq-plugins enable rabbitmq_management
   b) rabbitmq-plugins enable rabbitmq_stomp
   c) rabbitmq-plugins enable rabbitmq_web_stomp
4.start rabbitmq (widow-->type rabbitmq Service - start -->click on the icon)   
5. check rabbitmq is up and running http://localhost:15672 credentials guest/guest


http://localhost:3015/inventory/updateInventory

{  
   "message":"There is only 100 left in stok hurry up !",
   "availableStockCount":10,
   "additionalMessage":"",
   "productId":"1003"
}
  