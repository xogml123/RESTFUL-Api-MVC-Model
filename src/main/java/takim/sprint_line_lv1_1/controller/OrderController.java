package takim.sprint_line_lv1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import takim.sprint_line_lv1_1.domain.Order;

import java.util.List;

@Controller
public class OrderController {

    //@PostMapping

    @GetMapping("/")
    public String home() {
        return "index";
    }

   /* @GetMapping("/orders")
    public List<Order> phoneNumbers() {
        return ;
    }*/
}
