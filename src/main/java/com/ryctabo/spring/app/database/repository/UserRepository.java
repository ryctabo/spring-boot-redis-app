package com.ryctabo.spring.app.database.repository;

import com.ryctabo.spring.app.database.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public interface UserRepository extends MongoRepository<User, String> {}
