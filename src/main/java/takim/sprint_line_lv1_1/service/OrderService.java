package takim.sprint_line_lv1_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takim.sprint_line_lv1_1.domain.Order;
import takim.sprint_line_lv1_1.repository.JDBCTemplateOrderRepository;
import takim.sprint_line_lv1_1.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long join(Order order) {
        orderRepository.save(order);
        return (order.getId());
    }

    public List<Order> findOrders() {
        return orderRepository.findAll();
    }
}
