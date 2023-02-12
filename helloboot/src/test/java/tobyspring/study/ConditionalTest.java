package tobyspring.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(TrueCondition.class)
	@interface TrueConditional{}
	
	@Configuration
//	@Conditional(TrueCondition.class)
	@TrueConditional
	static class Config1{
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(FalseCondition.class)
	@interface FalseConditional{}
	
	@Configuration
//	@Conditional(FalseCondition.class)
	@FalseConditional
	static class Config2{
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}
	
	static class TrueCondition implements Condition{
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return true;
		}
	}
	static class FalseCondition implements Condition{
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return false;
		}
	}
	
	
	
	static class MyBean{
	}
	
	
}
