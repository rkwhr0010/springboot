package tobyspring.config;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class OnMyClassCondition implements Condition {
	//중복방지를 위해 메타어노테이션화
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String,Object> attrs = 
				metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
		String value = (String)attrs.get("value");
		return ClassUtils.isPresent(value, context.getClassLoader());
	}

}
