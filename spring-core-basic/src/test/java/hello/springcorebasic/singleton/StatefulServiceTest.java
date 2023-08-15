package hello.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

		StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
		StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

		// Thread A: 사용자 A 10000원 주문
		int userAPrice = statefulService1.order("userA", 10000);
		// Thread B: 사용자 B 20000원 주문
		int userBPrice = statefulService2.order("userB", 20000);

		// Thread A: 사용자 A 주문 금액 조회
		System.out.println("price=" + userAPrice);

		assertThat(userAPrice).isEqualTo(10000);
	}

	static class TestConfig {

		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}