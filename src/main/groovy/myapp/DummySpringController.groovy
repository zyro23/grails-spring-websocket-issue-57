package myapp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/dummySpring")
class DummySpringController {

	@Autowired
	@Qualifier("dummyBean1")
	DummyBean dummyBean1

	@Autowired
	@Qualifier("dummyBean2")
	DummyBean dummyBean2

	@Autowired
	@Qualifier("dummyBean3")
	DummyBean dummyBean3

	@RequestMapping('/one-${random.uuid}')
	@ResponseBody
	String one() {
		return "one"
	}

	@RequestMapping('/two-${random.uuid}')
	@ResponseBody
	String two() {
		return "two"
	}

	@RequestMapping('/three-${random.uuid}')
	@ResponseBody
	String three() {
		return "three"
	}

	@RequestMapping('/four-${random.uuid}')
	@ResponseBody
	String four() {
		return "four"
	}

	@RequestMapping('/five-${random.uuid}')
	@ResponseBody
	String five() {
		return "five"
	}

	@RequestMapping('/six-${random.uuid}')
	@ResponseBody
	String six() {
		return "six"
	}

	@RequestMapping('/seven-${random.uuid}')
	@ResponseBody
	String seven() {
		return "seven"
	}

	@RequestMapping('/eight-${random.uuid}')
	@ResponseBody
	String eight() {
		return "eight"
	}

	@RequestMapping('/nine-${random.uuid}')
	@ResponseBody
	String nine() {
		return "nine"
	}

	@RequestMapping('/ten-${random.uuid}')
	@ResponseBody
	String ten() {
		return "ten"
	}

}
