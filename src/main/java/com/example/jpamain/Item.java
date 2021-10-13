package com.example.jpamain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item extends BaseEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private int price;
  private int stockQuantity;

  @OneToMany(mappedBy = "item")
  private List<CategoryItem> categoryItems = new ArrayList<>();

}