package yun.springpractice.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Item {

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 주문상품에서 상품을 참조할 일을 많으나 역은 거의 없기 떄문에
    // 양방향이 아닌 단방향으로 설계했고, 그러인해 item 엔터티에는 OrderItem이 없다.

}
