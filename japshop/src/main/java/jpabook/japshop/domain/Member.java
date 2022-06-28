package jpabook.japshop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="memeber_id")
    private long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member") // mappedBy 연관관계 주인이 아닐 때 적어줌
    private List<Order> orders = new ArrayList<>();
}
