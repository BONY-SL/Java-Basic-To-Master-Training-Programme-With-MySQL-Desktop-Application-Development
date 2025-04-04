package com.springboot.academy.pointofsale.repo;


import com.springboot.academy.pointofsale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {


    Optional<Item> findByItemNameAndAvailable(String name ,boolean isAvailable);

    @Query("SELECT i FROM Item i WHERE i.itemName = :name AND i.available = :status")
    Optional<Item> findByItemNameAndAvailableEquals(@Param("name") String name, @Param("status") boolean isAvailable);

    List<Item> findAllByAvailableEquals(boolean status);

    Page<Item> findAllByAvailableEquals(boolean activeStatus, Pageable pageable);


    int countAllByAvailableEquals(boolean activeStatus);
}
