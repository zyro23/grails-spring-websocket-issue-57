package myapp

import grails.artefact.Controller
import groovy.util.logging.Slf4j

@Slf4j
@grails.web.Controller
class DummyGrailsController implements Controller {

	static scaffold = Dummy

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
