package com.example.jpamain;

import com.example.jpamain.domain.Address;
import com.example.jpamain.domain.Member;
import com.example.jpamain.domain.MemberDTO;
import com.example.jpamain.domain.Team;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Main4_JPQL_1 {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Team team1 = new Team();
      team1.setName("teamA");
      em.persist(team1);

      Team team2 = new Team();
      team2.setName("teamB");
      em.persist(team2);

      Member member1 = new Member();
      member1.setName("member1");
      member1.setAge(10);
      member1.changeTeam(team1);
      em.persist(member1);

      Member member2 = new Member();
      member2.setName("member2");
      member2.setAge(11);
      member2.changeTeam(team1);
      em.persist(member2);

      Member member3 = new Member();
      member3.setName("member3");
      member3.setAge(12);
      member3.changeTeam(team2);
      em.persist(member3);

      em.flush();
      em.clear();

      int count = em.createQuery("update Member m set m.age = 30")
              .executeUpdate();

      System.out.println("count = " + count);

      tx.commit();

    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();
  }

}
