package tobyspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import tobyspring.config.MyAutoConfiguration;


@MyAutoConfiguration
public class ServerPropertiesConfig {
	@Bean
	public ServerProperties properties(Environment env) {
		//프로퍼티 파일을 읽어서 일일이 내가 만든 프로퍼티 객체에 바인딩 할 필요없이 자동화
		return Binder.get(env).bind("", ServerProperties.class).get();
	}
}
