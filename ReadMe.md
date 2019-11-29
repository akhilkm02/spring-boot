Local set up
-------------------------------------
Steps to start:-

1. Please install Mongo DB with Compass

2. Start all services

3. Create a DB entry

   a) open postman 
   
   
   http://localhost:3013/pdp/create  (POST)
   
     Headers:-
  
    content-type  application/json
   
   1. First product
   
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
  
  2. Second product
  
	{
	"productName":"Perfect Tank", "productId":1001, "rating":5, "price":519.0, "attributes1":[
	"S", "M", "M", "L" ], "attributes2":[
	"GIRL", "NICE GIRL", "WOMANS" ], "attributes3":[
	"black", "red", "white" ], "attrName1":"SIZE", "attrName2":"SIZE TYPE", "attrName3":"COLOR",
	"img1":"https://s7.jjill.com/is/image/JJill/702896_ALT1?$pdp_thumb2$",
	"img2":"https://s7.jjill.com/is/image/JJill/702896_BACK?$pdp_thumb2$", 
	"img3":"https://s7.jjill.com/is/image/JJill/702896_SIDE?$pdp_thumb2$", 
	"img4":"https://s7.jjill.com/is/image/JJill/702896_220?$pdp_thumb2$"
	}
	
  3. Third product
  
    {
	"productName":"Perfect Reversible Tank", "productId":1002, "rating":5, "price":519.0, "attributes1":[
	"S", "M", "M", "L" ], "attributes2":[
	"GIRL", "NICE GIRL", "WOMANS" ], "attributes3":[
	"black", "red", "white" ], "attrName1":"SIZE", "attrName2":"SIZE TYPE", "attrName3":"COLOR",
	"img1":"https://s7.jjill.com/is/image/JJill/123791_ALT2?$pdp_thumb2$",
	"img2":"https://s7.jjill.com/is/image/JJill/123791_ALT1?$pdp_thumb2$", 
	"img3":"https://s7.jjill.com/is/image/JJill/123791_BACK?$pdp_thumb2$", 
	"img4":"https://s7.jjill.com/is/image/JJill/123791_SIDE?$pdp_thumb2$"
	}


Hit the below url http://localhost:3010/1000 :)   

WebSocket with rabbitmq:-
--------------------------

1. Install otp_win64_21.3.exe,rabbitmq-server-3.7.14.exe (attached in the exe.zip file)
2. Navigate to C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14\sbin
3. run the following commands
   
   a) rabbitmq-plugins enable rabbitmq_management
   b) rabbitmq-plugins enable rabbitmq_stomp
   c) rabbitmq-plugins enable rabbitmq_web_stomp
4. start rabbitmq (widow-->type rabbitmq Service - start -->click on the icon)   
5. check rabbitmq is up and running http://localhost:15672 credentials guest/guest


http://localhost:3015/inventory/updateInventory

{  
   "message":"There is only 100 left in stok hurry up !",
   "availableStockCount":10,
   "additionalMessage":"",
   "productId":"1003"
}

GCP setup
-----------------------------------------------------

1. https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app   

2. Search for "Go to the Google Cloud Platform Console." and click

3. Select kubernet engins

4. Enable billing

5. Click on the arrow right top corner (Active cloud shell) to get console

6. Run "gcloud container clusters delete hello-cluster  --zone=asia-northeast1-a" in the console  

7. Run "gcloud container clusters get-credentials hello-cluster --zone asia-northeast1-a --project pdp-ui-service" in the console  

8. Run "cat > total.yml" then copy paste the content from "service-deployment-total.yml" the ctrl+cat

9. Run "kubectl create -f total.yml"

10. Run "kubectl get services"

11. Get the external ip of the service "pdp"

12. "externalIp/productId" is the PDP url


Add product :- 

  http://externalIp/logic/pdp/create  (POST)
  
  Headers:-
  
  content-type  application/json
   
  
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
  


  