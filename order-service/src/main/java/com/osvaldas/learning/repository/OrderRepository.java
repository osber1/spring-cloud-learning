package com.osvaldas.learning.repository;

import com.osvaldas.learning.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
