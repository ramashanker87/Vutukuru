package com.rama.app.repository;

import com.rama.app.model.MessageData;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageData, Integer> {
}
