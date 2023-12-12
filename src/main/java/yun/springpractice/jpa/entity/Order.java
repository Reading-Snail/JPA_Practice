package yun.springpractice.jpa.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")         // ORDER는 ORDER BY의 예약어이므로 사용 불가.
public class Order {
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
    @Column
    private Long memberId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
