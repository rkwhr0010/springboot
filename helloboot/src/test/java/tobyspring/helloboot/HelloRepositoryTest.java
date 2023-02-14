package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {
	
	@Autowired
	HelloRepository helloRepository;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void findHelloFailed() {
		Assertions.assertThat(helloRepository.findHello("Toby")).isNull();
	}
	
	@Test
	void increaseeCount() {
		assertThat(helloRepository.countOf("Toby")).isEqualTo(0);
		helloRepository.increaseCount("Toby");
		assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
		helloRepository.increaseCount("Toby");
		assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
		
	}
	
	
}
