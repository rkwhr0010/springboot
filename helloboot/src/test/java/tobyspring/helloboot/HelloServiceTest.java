package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
	@Test
	void simpleHelloService() {
		SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

		String ret = helloService.sayHello("Test");

		Assertions.assertThat(ret).isEqualTo("Hello Test");
	}

	private HelloRepository helloRepositoryStub = new HelloRepository() {
		@Override
		public void increaseCount(String name) {
		}
		@Override
		public Hello findHello(String name) {
			return null;
		}
	};

	@Test
	void helloDecorator() {
		HelloDecorator decorator = new HelloDecorator(name -> name);

		String ret = decorator.sayHello("Test");
		Assertions.assertThat(ret).isEqualTo("*Test*");
	}

}
