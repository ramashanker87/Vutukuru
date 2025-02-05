package com.rama.app.controller;
import com.rama.app.model.User;
import com.rama.app.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/read")
  public Iterable<User> read() {
    return userRepository.findAll();
  }

  @PostMapping("/save")
  public String save(@RequestBody final User user) {
    System.out.println("Saving user: " + user);
    userRepository.save(user);
    return "save";
  }
}
