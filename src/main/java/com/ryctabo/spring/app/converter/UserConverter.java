package com.ryctabo.spring.app.converter;

import com.ryctabo.spring.app.database.document.User;
import com.ryctabo.spring.app.domain.UserData;
import org.springframework.stereotype.Component;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@Component
public class UserConverter implements DtoConverter<User, UserData, UserData> {

    @Override
    public User convertToEntity(UserData data) {
        User user = new User();
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setName(data.getName());
        user.setCreated(data.getCreated());
        user.setEnabled(data.getEnabled());
        return user;
    }

    @Override
    public UserData convertToDto(User entity) {
        return UserData.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .name(entity.getName())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .enabled(entity.isEnabled())
                .build();
    }
}
