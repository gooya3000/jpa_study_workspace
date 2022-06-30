package jpabook.japshop.domain;

import jpabook.japshop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"))
    private List<Item> items = new ArrayList<>();
    
    
    // 카테고리의 계층구조 표현 >> 다른 Entity가 아닌 나 자신을 연결하면 됌
    // 1. parent: 부모 카테고리로 N:1(부모) 연결
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    // 2. child: 자식 카테고리로 1:N(자식) 연결
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //==연관관계 (편의)메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }


}
