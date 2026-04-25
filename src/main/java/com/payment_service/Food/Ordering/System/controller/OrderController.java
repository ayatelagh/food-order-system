package com.payment_service.Food.Ordering.System.controller;
package com.example.overservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public String createOrder() {
        return "Order Created";
    }
}
@Autowired
private RestTemplate restTemplate;

@PostMapping("/pay")
public String payOrder() {
    String response = restTemplate.postForObject(
        "http://localhost:8082/payment",
        null,
        String.class
    );
    return "Order + " + response;
}