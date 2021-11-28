package takim.sprint_line_lv1_1.repository;

import takim.sprint_line_lv1_1.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    Optional<Order> findByName(String name);
    List<Order> findAll();
    void deleteById(Long id);
    void updateOrderContentIndexById(Long id, int orderContentIndex);
}
