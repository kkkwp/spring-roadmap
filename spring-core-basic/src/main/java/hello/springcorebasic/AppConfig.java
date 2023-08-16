package hello.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.springcorebasic.discount.DiscountPolicy;
import hello.springcorebasic.discount.RateDiscountPolicy;
import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.member.MemoryMemberRepository;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	// @Bean memberService -> new MemoryMemberRepository()
	// @Bean orderService -> new MemoryMemberRepository()

	@Bean
	public MemberService memberService() {
		// 1번
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		// 2번? 3번? -> 1번
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		// 1번
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
