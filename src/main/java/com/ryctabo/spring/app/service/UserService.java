package com.ryctabo.spring.app.service;

import com.ryctabo.spring.app.database.document.User;
import java.util.Collection;
import java.util.Optional;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public interface UserService {

    User create(User user);

    Optional<User> getById(String id);

    Collection<User> getAll();

    User update(User user);

    void delete(String id);
}
