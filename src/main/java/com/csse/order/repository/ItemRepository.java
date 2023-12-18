package com.csse.order.repository;

import com.csse.order.entity.Item;
import com.csse.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Long> {
}
