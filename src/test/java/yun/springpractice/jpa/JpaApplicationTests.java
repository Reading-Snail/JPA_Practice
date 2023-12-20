package yun.springpractice.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yun.springpractice.jpa.entity.Member;
import yun.springpractice.jpa.entity.Order;
import yun.springpractice.jpa.entity.OrderItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class EntityTests {

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void OrderTest(){
		Order orderSet = new Order();
		em.persist(orderSet);
		em.flush();
		Order orderGet = em.find(Order.class, 1);
		assertEquals(orderSet, orderGet);
	}
	@Test
	@Transactional
	void MemeberTest(){
		//Given
		Member memberSet = new Member();
		em.persist(memberSet);
		em.flush();
		//When
		Member memberGet = em.find(Member.class, 1L);
		//Member member = order.getMember();	//주문한 회원 참조 사용
		//Then
		assertEquals(memberSet, memberGet);
	}
	@Test // 객체 그래프 탐색 Order -> Member
	@Transactional
	void EntityGraphExploreTest1(){
		// Given
		Order orderSet = new Order();
		Member memberSet = new Member();
		orderSet.setMember(memberSet);	// 다대일 관계이므로 set으로 설정 할 수 있습니다.
		em.persist(orderSet);
		em.flush();
		// When
		Order orderGet = em.find(Order.class, 1L);
		Member memberGet = orderGet.getMember();
		// Then
		System.out.println("memberSet.id : " + memberSet.getId());
		System.out.println("memberGet.id : " + memberGet.getId());

		assertEquals(memberSet, memberGet);
	}
	@Test // 객체 그래프 탐색 2
	@Transactional
	void EntityGraphExploreTest2(){
		// Given
		Order orderSet = new Order();
		OrderItem orderItemSet1 = new OrderItem();
		orderSet.addOrderItem(orderItemSet1);	// 일대다의 관계이므로 set이 아닌 add로 추가해줍니다.
		OrderItem orderItemSet2 = new OrderItem();
		orderSet.addOrderItem(orderItemSet2);	// 일대다의 관계이므로 set이 아닌 add로 추가해줍니다.
		em.persist(orderSet);
		em.flush();
		// When
		Order orderGet = em.find(Order.class, 1L);
		OrderItem orderItem1 = orderGet.getOrderItems().get(0);
		OrderItem orderItem2 = orderGet.getOrderItems().get(1);
		// Then
		System.out.println("orderSet.id : " + orderGet.getId());
		System.out.println("orderItem1.id : " + orderItem1.getId());
		System.out.println("orderItem2.id : " + orderItem2.getId());

		assertEquals(orderItem1.getId()+1L, orderItem2.getId());
	}
}
