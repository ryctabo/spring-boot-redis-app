package com.ryctabo.spring.app.domain;

import java.io.Serializable;
import java.time.Instant;
import lombok.Builder;
import lombok.Value;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@Value
@Builder
public class UserData implements Serializable {

    String id;

    String username;

    String email;

    String name;

    Instant created;

    Instant updated;

    Boolean enabled;
}
