package myapp

import grails.artefact.Controller
import grails.core.GrailsApplication
import grails.plugin.springwebsocket.GrailsSimpAnnotationMethodMessageHandler
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.converter.MessageConverter
import org.springframework.messaging.handler.HandlerMethod
import org.springframework.messaging.simp.SimpMessageMappingInfo
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler
import org.springframework.stereotype.Component

import java.util.concurrent.CountDownLatch

@CompileStatic
@Slf4j
class ProfilingGrailsSimpAnnotationMethodMessageHandler extends GrailsSimpAnnotationMethodMessageHandler {

	ProfilingGrailsSimpAnnotationMethodMessageHandler(SubscribableChannel clientInboundChannel, MessageChannel clientOutboundChannel, SimpMessageSendingOperations brokerTemplate) {
		super(clientInboundChannel, clientOutboundChannel, brokerTemplate)
	}

	@Override
	void afterPropertiesSet() {
		long startTime = System.currentTimeMillis()
		super.afterPropertiesSet()
		log.debug "afterPropertiesSet() / detectHandlerMethods() took {} s", (System.currentTimeMillis() - startTime) / 1000
	}

}
