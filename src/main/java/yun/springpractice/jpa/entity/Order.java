package yun.springpractice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "orders")         // ORDER는 ORDER BY의 예약어이므로 사용 불가.
public class Order {
    @Id //@GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>(); //주문상품

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태

    // 연관관계 편의 메서드
    public void setMember(Member member){
        if(this.member != null) this.member.getOrders().remove(this);
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}

enum OrderStatus{
    ORDER, CANCEL
}