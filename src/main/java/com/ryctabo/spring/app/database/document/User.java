package com.ryctabo.spring.app.database.document;

import java.io.Serializable;
import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@Data
@Document(collection = "users")
public class User implements Serializable {

    @Id private String id;

    @Indexed(unique = true)
    private String username;

    @Indexed private String email;

    private String name;

    private Instant created;

    private Instant updated;

    private boolean enabled;
}
