package yun.springpractice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="ORDERITEM_ID")
    private Long id;
    @Column
    private Long itemId;
    @Column
    private Long orderId;

    private int orderPrice;
    private int count;
}
