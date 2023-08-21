package hello.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	// basePackages = "hello.springcorebasic.member",
	// basePackageClasses = AutoAppConfig.class,
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

	@Bean(name = "memoryMemberRepository")
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
