package takim.sprint_line_lv1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import takim.sprint_line_lv1_1.domain.Order;

import java.util.List;

@Controller
public class OrderController {


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/orders")
    public String orders() {
        return "orders";
    }
   /* @GetMapping("/orders")
    public List<Order> phoneNumbers() {
        return ;
    }*/
}
