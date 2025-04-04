package com.springboot.academy.pointofsale.repo;

import com.springboot.academy.pointofsale.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
}
