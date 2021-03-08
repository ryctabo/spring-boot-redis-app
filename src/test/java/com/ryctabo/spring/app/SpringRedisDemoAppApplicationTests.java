package com.ryctabo.spring.app;

import static org.assertj.core.api.Assertions.assertThat;

import com.ryctabo.spring.app.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRedisDemoAppApplicationTests {

    @Autowired private UserController userController;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }
}
