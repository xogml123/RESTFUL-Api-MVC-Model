package takim.sprint_line_lv1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import takim.sprint_line_lv1_1.domain.Order;
import takim.sprint_line_lv1_1.service.OrderService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/orders/update-form")
    public String orderUpdatePage(@RequestParam Long id, Model model){
        Optional<Order> optionalOrder = orderService.findById(id);
        Order order;
        if (optionalOrder.isPresent())
        {
            order = optionalOrder.get();
        }
        else
            return "error";
        model.addAttribute("order", order);
        return "order_update_form";
    }

    @PostMapping("/orders")
    public String createOrder(OrderForm orderForm) {
        if (orderForm.getName().equals("") || orderForm.getOrderContentIndex() <= 0 ||
                orderForm.getOrderContentIndex() > 7)
            return "redirect:/error";
        Order order =new Order();
        order.setName(orderForm.getName());
        order.setOrderContentIndex(orderForm.getOrderContentIndex());
        orderService.join(order);
        return "redirect:/";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
       return "orders";
    }

    @PatchMapping("/orders/{id}")
    public String updateOrder(@RequestBody OrderUpdateForm orderUpdateForm, @PathVariable Long id, Model model) {
        if (orderUpdateForm.getOrderContentIndex() <= 0 ||
                orderUpdateForm.getOrderContentIndex() > 7)
            return "error";
        orderService.updateOrder(id, orderUpdateForm.getOrderContentIndex());
        return "orders";
    }
}
