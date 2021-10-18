package com.example.jpamain;

import com.example.jpamain.domain.Member;
import com.example.jpamain.domain.Order;
import com.example.jpamain.domain.OrderStatus;
import com.example.jpamain.domain.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

//@SpringBootApplication
//public class JpaMainApplication {
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
//      Team teamA = new Team();
//      teamA.setName("teamA");
//      em.persist(teamA);
//
//      Team teamB = new Team();
//      teamB.setName("teamB");
//      em.persist(teamB);
//
//      Member member1 = new Member();
//      member1.setName("사용자");
//      member1.setTeam(teamA);
//      em.persist(member1);
//
//      Member member2 = new Member();
//      member2.setName("사용자2");
//      member2.setTeam(teamB);
//      em.persist(member2);
//
//      em.flush();
//      em.clear();
//
//      //JPQL 쿼리문
//      List<Member> results = em.createQuery("select m from Member m", Member.class)
//              .getResultList();
//      System.out.println("results = " + results);
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

//}
