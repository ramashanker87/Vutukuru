package com.rama.app.repository;

import com.rama.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Integer>{
}
