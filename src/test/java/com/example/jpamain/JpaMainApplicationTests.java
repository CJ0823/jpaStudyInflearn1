package com.example.jpamain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class JpaMainApplicationTests {

  @Test
  void overrodeTest() {

    List<String> list = List.of("사자", "호랑이", "사자", "토끼", "거북이", "거북이", "사자");

    HashSet<String> hs = new HashSet<>();
    for (String el : list) {
      if (list.indexOf(el) != list.lastIndexOf(el)) {
        hs.add(el);
      }
    }

    System.out.println("hs = " + hs);
  }

}
