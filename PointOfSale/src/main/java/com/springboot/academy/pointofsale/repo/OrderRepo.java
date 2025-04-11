package com.springboot.academy.pointofsale.repo;

import com.springboot.academy.pointofsale.entity.Order;
import com.springboot.academy.pointofsale.util.queryinterface.OrderDetailsInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT C.customer_name as customerName, " +
            "C.cus_address as customerAddress," +
            " C.conts_number as contactNumber," +
            " O.order_date as date, " +
            "O.order_total_price as orderTotalPrice " +
            "FROM customer C JOIN orders O ON C.customer_id = O.customer_id",
            nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails();
}
