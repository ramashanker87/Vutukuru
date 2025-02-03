package com.revanth.app.controler;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

  @GetMapping("/greet")
  public String greet() {
    return "Greet World";
  }
  @PostMapping("/hello")
  public String hello() {
    return "Hello World";
  }
  @PutMapping("/hi")
  public String hi() {
    return "Hi World";
  }
  @DeleteMapping("/thanks")
  public String thanks() {
    return "Thanks World";
  }
}
