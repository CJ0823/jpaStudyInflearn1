package com.example.jpamain;

import com.example.jpamain.domain.Child;
import com.example.jpamain.domain.Member;
import com.example.jpamain.domain.Parent;
import com.example.jpamain.domain.Team;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

//@SpringBootApplication
//public class JpaMainApplication2 {
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
//      Child child1 = new Child();
//      Child child2 = new Child();
//
//      Parent parent = new Parent();
//      parent.addChild(child1);
//      parent.addChild(child2);
//
//      em.persist(parent);
//
//      em.flush();
//      em.clear();
//
//      Parent parent1 = em.find(Parent.class, parent.getId());
//      parent1.getChildList().remove(0);
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
