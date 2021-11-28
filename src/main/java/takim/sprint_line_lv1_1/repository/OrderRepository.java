package takim.sprint_line_lv1_1.repository;

import takim.sprint_line_lv1_1.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long Id);
    Optional<Order> findByName(String name);
    List<Order> findAll();
}
