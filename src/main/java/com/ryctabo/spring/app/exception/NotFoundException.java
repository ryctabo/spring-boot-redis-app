package com.ryctabo.spring.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public class NotFoundException extends ResponseStatusException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
