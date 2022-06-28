package jpabook.japshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;  // member-order 연관 관계 주인!
    private List<OrderItem> orderItems = new ArrayList<>();
    private Delivery delivery;
    private OrderStatus status;
}
