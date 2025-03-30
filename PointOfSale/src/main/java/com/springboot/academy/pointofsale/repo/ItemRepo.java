package com.springboot.academy.pointofsale.repo;


import com.springboot.academy.pointofsale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {


    Optional<Item> findByItemNameAndAvailable(String name ,boolean isAvailable);

    @Query("SELECT i FROM Item i WHERE i.itemName = :name AND i.available = :status")
    Optional<Item> findByItemNameAndAvailableEquals(@Param("name") String name, @Param("status") boolean isAvailable);


}
