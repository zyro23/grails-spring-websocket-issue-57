package myapp

import grails.plugin.springwebsocket.GrailsSimpAnnotationMethodMessageHandler
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler
import org.springframework.stereotype.Component

@CompileStatic
@Component
@Slf4j
class ProfilingSpringSimpAnnotationMethodMessageHandler extends SimpAnnotationMethodMessageHandler {

	ProfilingSpringSimpAnnotationMethodMessageHandler(SubscribableChannel clientInboundChannel, MessageChannel clientOutboundChannel, SimpMessageSendingOperations brokerTemplate) {
		super(clientInboundChannel, clientOutboundChannel, brokerTemplate)
	}

	@Override
	void afterPropertiesSet() {
		long startTime = System.currentTimeMillis()
		super.afterPropertiesSet()
		log.debug "afterPropertiesSet() / detectHandlerMethods() took {} s", (System.currentTimeMillis() - startTime) / 1000
	}
}
