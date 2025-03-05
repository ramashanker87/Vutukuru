package com.rama.app.controller;

import com.rama.app.model.MessageData;
import com.rama.app.repository.MessageRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
  private final MessageRepository messageRepository;

  public MessageController(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @GetMapping("/read/all")
  public Iterable<MessageData> readAll() {
    return messageRepository.findAll();
  }

  @PostMapping("/save")
  public MessageData save(@RequestBody MessageData message) {
    return messageRepository.save(message);
  }

  @PutMapping("/update")
  public MessageData update(@RequestBody MessageData message) {
    return messageRepository.save(message);
  }

  @DeleteMapping("/delete")
  public void delete(@RequestParam int id) {
    messageRepository.deleteById(id);
  }
}
