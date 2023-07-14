package hello.springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.springintroduction.repository.MemberRepository;
import hello.springintroduction.repository.MemoryMemberRepository;
import hello.springintroduction.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
