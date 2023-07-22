package hello.springcorebasic.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;

class OrderServiceTest {

	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}