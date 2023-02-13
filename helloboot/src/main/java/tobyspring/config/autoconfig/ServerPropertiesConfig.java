package tobyspring.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import tobyspring.config.MyAutoConfiguration;


@MyAutoConfiguration
public class ServerPropertiesConfig {
	@Bean
	public ServerProperties properties(Environment env) {
		ServerProperties properties = new ServerProperties();
		properties.setContextPath(env.getProperty("contextPath"));
		properties.setPort(Integer.valueOf(env.getProperty("port")));
		return properties;
	}
}
