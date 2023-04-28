package com.shopee.ecommerce.dao;

import com.shopee.ecommerce.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long>{

    List<Order> findByCustomerEmail(@Param("email") String email);

    List<Order> findByOrderTrackingNumber(@Param("tracking_number") String order_tracking_number);

}

