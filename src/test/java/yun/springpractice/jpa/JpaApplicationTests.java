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
class JpaApplicationTests {

	@Autowired
	EntityManager em;
	@Test
	void contextLoads() {
		System.out.println("contextLoads");
	}

	@Test
	@Transactional
	void EntityPersistTest(){
		Order origin = new Order();
		em.persist(origin);
		Order order = em.find(Order.class, 1);
		//Member member = order.getMember();	//주문한 회원 참조 사용
		assertEquals(origin, order);
	}
	@Test // 객체 그래프 탐색 1
	@Transactional
	void EntityGraphExploreTest1(){
		// Given
		Order originOrder = new Order();
		originOrder.setId(25L);
		Member originMember = new Member();
		originMember.setId(100L);
		originOrder.setMember(originMember);

		// When
		em.persist(originOrder);
		Order order = em.find(Order.class, 25L);
		Member member = order.getMember();

		// Then
		System.out.println("member.id : " + originMember.getId());
		System.out.println("member.id : " + member.getId());

		assertEquals(originMember, member);
	}
	@Test // 객체 그래프 탐색 2
	@Transactional
	void EntityGraphExploreTest2(){
		// Given
		Order originOrder = new Order();
		originOrder.setId(1L);
		OrderItem originOrderItem1 = new OrderItem();
		originOrderItem1.setId(100L);
		originOrder.addOrderItem(originOrderItem1);
		em.persist(originOrder);

		// When
		Order order = em.find(Order.class, 1L);
		OrderItem orderItem1 = order.getOrderItems().get(0);

		// Then
		System.out.println("member.id : " + order.getId());
		System.out.println("member.id : " + orderItem1.getId());

		assertEquals(originOrderItem1, orderItem1);
	}
}
