package inventory.pdpinventoryservice.config;
import java.util.Set;

import org.springframework.messaging.simp.user.SimpSubscription;
import org.springframework.messaging.simp.user.SimpSubscriptionMatcher;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.messaging.DefaultSimpUserRegistry;

/*package inventory.pdpinventoryservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/pdp-chat")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/pdp");
    }
}
*/

public class WebSocketConfig extends WebSocketMessageBrokerStats{
	
@Override
public String getStompBrokerRelayStatsInfo() {
	// TODO Auto-generated method stub
	System.out.println("info===="+super.getStompBrokerRelayStatsInfo());
	this.setLoggingPeriod(100);
	return super.getStompBrokerRelayStatsInfo();
}

@Override
	public void setLoggingPeriod(long period) {
		// TODO Auto-generated method stub
		super.setLoggingPeriod(period);
	}

}