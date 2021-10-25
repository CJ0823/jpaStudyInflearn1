package com.example.jpamain;

import com.example.jpamain.domain.Address;
import com.example.jpamain.domain.Member;
import com.example.jpamain.domain.MemberDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
      List<Member> members = IntStream.range(0, 100).boxed().map(i -> {
        Member member = new Member();
        member.setName("member " + i);
        member.setAge(i);
        member.setHomeAddress(new Address("city1", "road1", 1234));
        em.persist(member);
        return member;
      }).collect(Collectors.toList());

      em.flush();
      em.clear();

      List<Member> resultList = em.createQuery("select m from Member m order by m.age desc ", Member.class)
              .setFirstResult(1)
              .setMaxResults(10)
              .getResultList();

      System.out.println("resultList.size() = " + resultList.size());
      for (Member member1 : resultList) {
        System.out.println("member1 = " + member1);
      }

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
