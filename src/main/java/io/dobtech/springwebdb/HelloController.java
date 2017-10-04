package io.dobtech.springwebdb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    @RequestMapping("/")
    public String index() {
        return "Hello World from Spring Boot on " + hostname;
    }
}