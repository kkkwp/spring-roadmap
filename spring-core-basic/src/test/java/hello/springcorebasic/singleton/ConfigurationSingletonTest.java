package hello.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.springcorebasic.AppConfig;
import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		// 모두 같은 인스턴스를 참고하고 있다.
		System.out.println("memberService -> memberRepository=" + memberService.getMemberRepository());
		System.out.println("orderService -> memberRepository=" + orderService.getMemberRepository());
		System.out.println("memberRepository=" + memberRepository);

		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}

	@Test
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// AppConfig도 스프링 빈으로 등록된다.
		AppConfig bean = ac.getBean(AppConfig.class);

		//출력: bean=class hello.springcorebasic.AppConfig$$EnhancerBySpringCGLIB$$bcbb7aa3
		System.out.println("bean=" + bean.getClass());
	}
}
