package jpabook.japshop.domain;

import jpabook.japshop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY) //기본은 EAGER(즉시로딩), 절대 쓰면 안됌.. 하나 조회할 때 모든 연관관계 데이터를 다 가져옴;;
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice;
    private int count;
}
