package inventory.pdpinventoryservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import inventory.pdpinventoryservice.model.InventoryResponse;

@Configuration
@EnableWebSocketMessageBroker
public class InventoryWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private SimpMessageSendingOperations template;
	public static Map<String, String> poductMap = new HashMap<>();

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/inventoryService").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableStompBrokerRelay("/topic")
		.setRelayHost("localhost")
		.setRelayPort(61613)
		.setClientLogin("guest")
	    .setClientPasscode("guest");
		/**
		 * Not required for inventory since no info pass from browser to server
		 */
		registry.setApplicationDestinationPrefixes("/inv");
	}

	@EventListener(SessionConnectEvent.class)
	public void handleWebsocketConnectListner(SessionConnectEvent event) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		if (!"all".equals(sha.getNativeHeader("productId").get(0))) {
			poductMap.put(sha.getSessionId(), sha.getNativeHeader("productId").get(0));
			//countNumberOfViewers(poductMap, sha.getNativeHeader("productId").get(0)); //This is not working for the newly opened PDP
		}

	}

	@EventListener(SessionDisconnectEvent.class)
	public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		String productId = findAndRemoveDisconnectedProduct(poductMap, sha.getSessionId());
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
		broadcast(productId,"There are "+numberOfViewers[0]+ " people currently viewing this item");
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
		return productId[0];
	}
	
	private void broadcast(String productId,String message) {
         if(!"all".equals(productId)) {
        	 template.convertAndSend("/topic/product."+productId, new InventoryResponse(message));
        	 System.out.println("broadcasted with message : "+message);
         }
		
	}

	public static Map<String, String> getPoductMap() {
		return poductMap;
	}

	public static void setPoductMap(Map<String, String> poductMap) {
		InventoryWebSocketConfig.poductMap = poductMap;
	}

}
