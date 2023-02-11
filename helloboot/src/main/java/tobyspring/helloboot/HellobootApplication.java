package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import tobyspring.config.MySpringBootApplication;


@MySpringBootApplication
public class HellobootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class,args);
	}
	
}
