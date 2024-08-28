package com.example.springintroduction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springintroduction.aop.TimeTraceAop;
import com.example.springintroduction.repository.MemberRepository;
import com.example.springintroduction.service.MemberService;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	@Bean
	public TimeTraceAop timeTraceAop() {
		return new TimeTraceAop();
	}

	// 스프링 데이터 JPA가 SpringDataJpaMemberRepository를 스프링 빈으로 자동 등록해준다.
}
