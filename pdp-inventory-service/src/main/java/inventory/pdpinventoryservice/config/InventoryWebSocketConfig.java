package inventory.pdpinventoryservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import inventory.pdpinventoryservice.model.InventoryResponse;

@Configuration
@EnableWebSocketMessageBroker
public class InventoryWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Autowired
    SimpMessagingTemplate template;
	Map<String, String> poductMap = new HashMap<>();

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/inventoryService").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/product", "/inventory");

		/**
		 * Not required for inventory since no info pass from browser to server
		 */
		registry.setApplicationDestinationPrefixes("/inv");
	}

	@EventListener(SessionConnectEvent.class)
	public void handleWebsocketConnectListner(SessionConnectEvent event) {
		System.out.println("SessionConnectEvent event : " + event);
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		System.out.println("SessionId : " + sha.getSessionId());
		System.out.println("Native Headers : " + sha.getNativeHeader("productId").get(0));
		if (!"all".equals(sha.getNativeHeader("productId").get(0))) {
			poductMap.put(sha.getSessionId(), sha.getNativeHeader("productId").get(0));
			System.out.println("poductMap=" + poductMap);
			countNumberOfViewers(poductMap, sha.getNativeHeader("productId").get(0));
		}

	}

	@EventListener(SessionDisconnectEvent.class)
	public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
		System.out.println("SessionDisconnectEvent event : " + event);
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		System.out.println("SessionId : " + sha.getSessionId());
		System.out.println("poductMap=" + poductMap);
		String productId = findAndRemoveDisconnectedProduct(poductMap, sha.getSessionId());
		System.out.println("after removing the product from poductMap =" + poductMap);
		countNumberOfViewers(poductMap, productId);

	}

	private void countNumberOfViewers(Map<String, String> poductMap, String productId) {
		int[] numberOfViewers = { 0 };
		poductMap.forEach((key, value) -> {
			System.out.println("Item : " + key + " Count : " + value);
			if (productId.equals(value)) {
				numberOfViewers[0] = numberOfViewers[0] + 1;
			}
		});
		System.out.println("Total viewers for the product  with product Id :" + productId + " is  " + numberOfViewers[0]);
		broadcast(productId,"There are "+numberOfViewers[0]+ " of people  are currently viewing this item");
	}


	private String findAndRemoveDisconnectedProduct(Map<String, String> poductMapRemove, String sessionId) {
		String[] productId = { "" };
		poductMapRemove.forEach((key, value) -> {
			System.out.println("sessionId : " + key + " productId : " + value);
			if (sessionId.equals(key)) {
				productId[0] = value;
			}
		});

		poductMap.remove(sessionId);
		System.out.println("productId==" + productId[0]);
		return productId[0];
	}
	
	private void broadcast(String productId,String message) {
         if(!"all".equals(productId)) {
        	 template.convertAndSend("/product/"+productId, new InventoryResponse(message));
        	 System.out.println("broadcasted with message : "+message);
         }
		
	}

}
