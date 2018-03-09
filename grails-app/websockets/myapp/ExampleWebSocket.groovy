package myapp

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo


class ExampleWebSocket {

	@MessageMapping("/hellow")
	@SendTo("/topic/hellow")
	String hellow(String world) {
		return "hellow from controller, ${world}!"
	}

}
