package com.example.jpamain;

import com.example.jpamain.domain.Member;
import com.example.jpamain.domain.Order;
import com.example.jpamain.domain.OrderStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

@SpringBootApplication
public class JpaMainApplication {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Member member1 = new Member();
      member1.setName("사용자");

      em.persist(member1);

      em.flush();
      em.clear();

      Member refMember = em.getReference(Member.class, member1.getId());
      System.out.println("findMember1 = " + refMember.getClass());

      em.detach(refMember);
//      em.close();

      refMember.getName();

      tx.commit();

//      em.detach(findMember);

//      Member findMember = em.getReference(Member.class, member.getId());

//      System.out.println("findMember = " + findMember.getName());



    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();
  }

}
