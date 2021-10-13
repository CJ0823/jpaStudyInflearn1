package com.example.jpamain;

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

      Order order = new Order();
      order.setOrderDate(LocalDateTime.now());
      order.setStatus(OrderStatus.ACTIVE);

      em.persist(order);

      tx.commit();

    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }

}
