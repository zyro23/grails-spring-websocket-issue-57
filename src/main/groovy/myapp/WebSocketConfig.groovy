package myapp

import grails.plugin.springwebsocket.GrailsSimpAnnotationMethodMessageHandler
import grails.plugin.springwebsocket.GrailsWebSocketAnnotationMethodMessageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		messageBrokerRegistry.enableSimpleBroker "/queue", "/topic"
		messageBrokerRegistry.setApplicationDestinationPrefixes "/app"
	}

	@Override
	void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/stomp").withSockJS()
	}

	@Bean
	ProfilingGrailsSimpAnnotationMethodMessageHandler profilingGrailsSimpAnnotationMethodMessageHandler(
		SubscribableChannel clientInboundChannel,
		MessageChannel clientOutboundChannel,
		SimpMessageSendingOperations brokerMessagingTemplate
	) {
		def handler = new ProfilingGrailsSimpAnnotationMethodMessageHandler(clientInboundChannel, clientOutboundChannel, brokerMessagingTemplate)
		handler.destinationPrefixes = ["/app"]
		return handler
	}

	@Bean
	ProfilingGrailsWebSocketAnnotationMethodMessageHandler profilingGrailsWebSocketAnnotationMethodMessageHandler(
		SubscribableChannel clientInboundChannel,
		MessageChannel clientOutboundChannel,
		SimpMessageSendingOperations brokerMessagingTemplate
	) {
		def handler = new ProfilingGrailsWebSocketAnnotationMethodMessageHandler(clientInboundChannel, clientOutboundChannel, brokerMessagingTemplate)
		handler.destinationPrefixes = ["/app"]
		return handler
	}

	@Bean
	ProfilingSpringSimpAnnotationMethodMessageHandler profilingSpringSimpAnnotationMethodMessageHandler(
		SubscribableChannel clientInboundChannel,
		MessageChannel clientOutboundChannel,
		SimpMessageSendingOperations brokerMessagingTemplate
	) {
		def handler = new ProfilingSpringSimpAnnotationMethodMessageHandler(clientInboundChannel, clientOutboundChannel, brokerMessagingTemplate)
		handler.destinationPrefixes = ["/app"]
		return handler
	}
	
}
