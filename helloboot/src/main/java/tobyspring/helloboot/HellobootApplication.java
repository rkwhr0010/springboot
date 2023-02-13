package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import tobyspring.config.MySpringBootApplication;


@MySpringBootApplication
@AutoConfiguration
public class HellobootApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class,args);
	}
	
}
