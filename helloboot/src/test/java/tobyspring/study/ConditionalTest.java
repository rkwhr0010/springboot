package tobyspring.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ConditionalTest {
//	@Test
	void conditional() {
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		//true
		ac.register(Config1.class);
		ac.refresh();
		MyBean bean = ac.getBean(MyBean.class);
		
		
		//false
		AnnotationConfigWebApplicationContext ac2 = new AnnotationConfigWebApplicationContext();
		ac2.register(Config2.class);
		ac2.refresh();
		MyBean bean2 = ac.getBean(MyBean.class);
		
	}
	
	@Test
	void conditional2() {
		//true
		ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		contextRunner.withUserConfiguration(Config1.class)
		.run(context->{
			assertThat(context).hasSingleBean(MyBean.class);
			assertThat(context).hasSingleBean(Config1.class);
		});
		
		//false
		ApplicationContextRunner contextRunner2 = new ApplicationContextRunner();
		contextRunner2.withUserConfiguration(Config2.class)
		.run(context->{
			assertThat(context).doesNotHaveBean(MyBean.class);
			assertThat(context).doesNotHaveBean(Config1.class);
		});
		
	}
	
	@BooleanConditional(true)
	static class Config1{
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}

	@BooleanConditional(false)
	static class Config2{
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(BooleanCondition.class)
	@interface BooleanConditional{
		boolean value();
	}
	
	static class BooleanCondition implements Condition{
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			//애노테이션을 읽어 거기 정보를 활용 적절한 값 리턴
			Map<String,Object> annotationAttributes = 
					metadata.getAnnotationAttributes(BooleanConditional.class.getName());
			Boolean value = (Boolean) annotationAttributes.get("value");
			return value;
		}
	}
	
	static class MyBean{
	}
	
	
}
