package myapp

import grails.artefact.Controller
import grails.plugin.springwebsocket.WebSocket
import grails.plugin.springwebsocket.WebSocketArtefact
import groovy.util.logging.Slf4j

@Slf4j
@WebSocketArtefact
class DummyWebSocket implements WebSocket {

	DummyBean dummyBean1
	DummyBean dummyBean2
	DummyBean dummyBean3

	def one() {}
	def two() {}
	def three() {}
	def four() {}
	def five() {}
	def six() {}
	def seven() {}
	def eight() {}
	def nine() {}
	def ten() {}

}
