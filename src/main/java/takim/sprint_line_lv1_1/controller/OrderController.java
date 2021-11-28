package takim.sprint_line_lv1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import takim.sprint_line_lv1_1.domain.Order;
import takim.sprint_line_lv1_1.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        List<Order> orders = orderService.findOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/orders/update-page")
    public String orderUpdatePage(@Que)
    @PostMapping("/orders")
    public String create(OrderForm orderForm) {
        Order order =new Order();
        order.setName(orderForm.getName());
        order.setOrderContentIndex(orderForm.getOrderContentIndex());
        orderService.join(order);
        return "redirect:/";
    }

    @DeleteMapping("/orders/{id}")
    public String delete(@PathVariable Long id, Model model) {
        orderService.deleteOrder(id);
       return "orders";
    }
}
