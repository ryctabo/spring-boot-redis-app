package com.ryctabo.spring.app.controller;

import com.ryctabo.spring.app.converter.UserConverter;
import com.ryctabo.spring.app.database.document.User;
import com.ryctabo.spring.app.domain.UserData;
import com.ryctabo.spring.app.exception.NotFoundException;
import com.ryctabo.spring.app.service.UserService;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserConverter userConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserData post(@RequestBody UserData request) {
        User user = userService.create(userConverter.convertToEntity(request));
        return userConverter.convertToDto(user);
    }

    @GetMapping
    public Collection<UserData> get() {
        return userService.getAll().stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "User")
    public UserData get(@PathVariable String id) {
        return userService
                .getById(id)
                .map(userConverter::convertToDto)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#id", value = "User")
    public UserData update(@PathVariable String id, @RequestBody UserData request) {
        User user = userConverter.convertToEntity(request);
        user.setId(id);
        return userConverter.convertToDto(userService.update(user));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "User")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
