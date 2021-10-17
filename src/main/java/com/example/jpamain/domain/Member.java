package com.example.jpamain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String city;

  private String street;

  private Integer zipcode;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
}
