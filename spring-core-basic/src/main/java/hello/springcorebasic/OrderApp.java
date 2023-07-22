package hello.springcorebasic;

import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.order.Order;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}
}
