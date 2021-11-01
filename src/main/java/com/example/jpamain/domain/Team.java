package com.example.jpamain.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @BatchSize(size = 100)
  @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
  private List<Member> members = new ArrayList<>();

}
