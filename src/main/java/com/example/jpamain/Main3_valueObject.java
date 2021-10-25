package com.example.jpamain;

import com.example.jpamain.domain.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//@SpringBootApplication
//public class Main3_valueObject {
//
//  public static void main(String[] args) {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//    EntityManager em = emf.createEntityManager();
//
//    EntityTransaction tx = em.getTransaction();
//    tx.begin();
//
//    try {
//
//      Member member = new Member();
//      member.setName("member1");
//      member.setHomeAddress(new Address("city1", "road1", 1234));
//
//      member.getFavoriteFoods().add("해물탕");
//      member.getFavoriteFoods().add("삼겹살");
//      member.getFavoriteFoods().add("볶음밥");
//
//      em.persist(member);
//
//      em.flush();
//      em.clear();
//
//      System.out.println("=====================================");
//      Member member1 = em.find(Member.class, member.getId());
//      member1.getFavoriteFoods().remove("해물탕");
//      member1.getFavoriteFoods().add("순두부찌개");
//
//      em.persist(member1);
//
//      tx.commit();
//
//    } catch (Exception e) {
//      tx.rollback();
//      e.printStackTrace();
//    } finally {
//      em.close();
//    }
//    emf.close();
//  }
//
//}
