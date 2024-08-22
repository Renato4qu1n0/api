package barber.shop.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/hello")
public class helloController {
    @GetMapping
    public String olaMundo() {
        return "Hello Spring World!";
    }
}
