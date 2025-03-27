package com.springboot.academy.pointofsale.repo;

import com.springboot.academy.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer > {

    List<Customer> findAllByIsActiveEquals(boolean status);

    @Query("SELECT c FROM Customer c WHERE c.isActive = :status")
    List<Customer> findAllByActiveEquals(@Param("status") boolean status);
}
