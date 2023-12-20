package yun.springpractice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class Item {

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 주문상품에서 상품을 참조할 일을 많으나 역은 거의 없기 떄문에
    // 양방향이 아닌 단방향으로 설계했고, 그러인해 item 엔터티에는 OrderItem이 없다.

    @ManyToMany(mappedBy = "items")
    private List<Category> items = new ArrayList<>();
}
