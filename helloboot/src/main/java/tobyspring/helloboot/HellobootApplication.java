package tobyspring.helloboot;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import tobyspring.config.MySpringBootApplication;


@MySpringBootApplication
@AutoConfiguration
public class HellobootApplication {
	
	private final JdbcTemplate jdbcTemplate;
	
	public HellobootApplication(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class,args);
	}
	
}
