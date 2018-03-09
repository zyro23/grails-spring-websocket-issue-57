package myapp

import grails.plugin.springwebsocket.GrailsSimpAnnotationMethodMessageHandler
import grails.plugin.springwebsocket.GrailsWebSocketAnnotationMethodMessageHandler
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Component

@CompileStatic
@Slf4j
class ProfilingGrailsWebSocketAnnotationMethodMessageHandler extends GrailsWebSocketAnnotationMethodMessageHandler {

	ProfilingGrailsWebSocketAnnotationMethodMessageHandler(SubscribableChannel clientInboundChannel, MessageChannel clientOutboundChannel, SimpMessageSendingOperations brokerTemplate) {
		super(clientInboundChannel, clientOutboundChannel, brokerTemplate)
	}

	@Override
	void afterPropertiesSet() {
		long startTime = System.currentTimeMillis()
		super.afterPropertiesSet()
		log.debug "afterPropertiesSet() / detectHandlerMethods() took {} s", (System.currentTimeMillis() - startTime) / 1000
	}

}
