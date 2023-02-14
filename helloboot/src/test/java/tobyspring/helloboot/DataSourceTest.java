package tobyspring.helloboot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //스프링 컨텍스트를 이용하는 컨테이너 테스트가능
@ContextConfiguration(classes = HellobootApplication.class)//모든 빈 구성정보를 가져오는 시작점
@TestPropertySource("classpath:/application.properties")//프로퍼티를 읽는 것은 부트의 특징이라 별도 설정 필요
public class DataSourceTest {
	@Autowired DataSource dataSource;
	
	@Test
	void connect() throws SQLException{
		Connection connection = dataSource.getConnection();
		connection.close();
	}
	
	
}
