package tobyspring.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import tobyspring.config.ConditaionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditaionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
	
	@Bean("jettyWebServerFactory")
	public ServletWebServerFactory servletWebServerFactory() {
		return new JettyServletWebServerFactory();
	}
	
}
