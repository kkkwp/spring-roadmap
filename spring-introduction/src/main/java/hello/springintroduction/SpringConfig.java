package hello.springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.springintroduction.repository.MemberRepository;
import hello.springintroduction.service.MemberService;

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
}
