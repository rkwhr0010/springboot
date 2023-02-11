package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
	
	@Test
	void HelloController() {
		HelloController controller = new HelloController(name->name);
		String ret = controller.hello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Test");
		
	}
	
	//실패케이스
	@Test
	void failsHelloController() {
		HelloController controller = new HelloController(name->name);
		//정의한 대로 예외가 잘 발생했는지
		Assertions.assertThatThrownBy(()->{
			controller.hello(null);
		}).isInstanceOf(IllegalArgumentException.class);
		
		Assertions.assertThatThrownBy(()->{
			controller.hello("");
		}).isInstanceOf(IllegalArgumentException.class);
	}
	
}
