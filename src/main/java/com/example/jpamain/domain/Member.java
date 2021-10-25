package com.example.jpamain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private Integer age;

  @Embedded
  private Period period;

  @Embedded
  private Address homeAddress;

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
  @Column(name = "FOOD_NAME") //String이 기본 값 타입이므로 컬럼 이름 적용 가능
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "ADDRESS_HISTORY", joinColumns = @JoinColumn(name = "MEMBER_ID"))
  private List<Address> addressHistory = new ArrayList<>();

  @Embedded
  @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
          @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
          @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
  })
  private Address workAddress;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "TEAM_ID")
  private Team team;


  @Override
  public String toString() {
    return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
//            ", period=" + period +
//            ", homeAddress=" + homeAddress +
//            ", favoriteFoods=" + favoriteFoods +
//            ", addressHistory=" + addressHistory +
//            ", workAddress=" + workAddress +
//            ", team=" + team +
            '}';
  }
}
