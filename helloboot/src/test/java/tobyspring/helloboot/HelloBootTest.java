package tobyspring.helloboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class) //스프링 컨텍스트를 이용하는 컨테이너 테스트가능
@ContextConfiguration(classes = HellobootApplication.class)//모든 빈 구성정보를 가져오는 시작점
@TestPropertySource("classpath:/application.properties")//프로퍼티를 읽는 것은 부트의 특징이라 별도 설정 필요
@Transactional
public @interface HelloBootTest {

}
