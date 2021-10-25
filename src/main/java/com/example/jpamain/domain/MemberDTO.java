package com.example.jpamain.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.SecondaryTable;

@Getter
@Setter
public class MemberDTO {

  private String name;
  private Period period;

  public MemberDTO(String name, Period period) {
    this.name = name;
    this.period = period;
  }
}
