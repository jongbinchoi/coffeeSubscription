package cafeSubscription.coffee.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class mainController {

    @GetMapping("/")
    public String mainP() {
        return "Hello World";
    }
}
