package tobyspring.helloboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
	
	private final HelloRepository repository;
	
	public SimpleHelloService(HelloRepository repository) {
		super();
		this.repository = repository;
	}



	public String sayHello(String name) {
		this.repository.increaseCount(name);
		
		return "Hello "+name;
	}



	@Override
	public int countOf(String name) {
		return this.repository.countOf(name);
	}
}
