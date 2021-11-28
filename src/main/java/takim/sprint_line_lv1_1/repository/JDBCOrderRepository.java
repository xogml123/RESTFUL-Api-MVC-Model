package takim.sprint_line_lv1_1.repository;

import takim.sprint_line_lv1_1.domain.Order;

import java.util.List;
import java.util.Optional;

public class JDBCOrderRepository implements OrderRepository {

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
