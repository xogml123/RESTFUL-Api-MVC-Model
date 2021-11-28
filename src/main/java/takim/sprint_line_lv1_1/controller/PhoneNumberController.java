package takim.sprint_line_lv1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import takim.sprint_line_lv1_1.domain.PhoneNumber;

import java.util.List;

@Controller
public class PhoneNumberController {

    //@PostMapping

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/phone_numbers")
    public List<PhoneNumber> phoneNumbers() {
        return ;
    }
}
