package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final HelloService helloService;
	private final ApplicationContext applicationContext;
	
	
	public HelloController(HelloService helloService, ApplicationContext applicationContext) {
		super();
		this.applicationContext = applicationContext;
		this.helloService = helloService;
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return  helloService.sayHello(Objects.requireNonNull(name));
	}

}
