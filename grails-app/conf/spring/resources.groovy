import myapp.DummyBean
import myapp.DummyGrailsController
import myapp.DummySpringController
import myapp.ProfilingGrailsSimpAnnotationMethodMessageHandler
import myapp.ProfilingSpringSimpAnnotationMethodMessageHandler
import myapp.WebSocketConfig

// Place your Spring DSL code here
beans = {

	webSocketConfig WebSocketConfig
	profilingGrailsSimpAnnotationMethodMessageHandler ProfilingGrailsSimpAnnotationMethodMessageHandler
	profilingSpringSimpAnnotationMethodMessageHandler ProfilingSpringSimpAnnotationMethodMessageHandler

	1.upto(3000) {
		"dummyBean${it}" DummyBean
	}

	1.upto(300) {
		"dummyGrailsController${it}"(DummyGrailsController) { bean ->
			bean.autowire = "byName"
			bean.lazyInit = true
		}
	}

	1.upto(300) {
		"dummySpringController${it}"(DummySpringController) {  bean ->
			bean.autowire = "byName"
			bean.lazyInit = true
		}
	}

}
