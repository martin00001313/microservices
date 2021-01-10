package com.example.demo.repositories;

import com.example.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author martin
 */
public interface UserRepository extends MongoRepository<User, String> {

}
