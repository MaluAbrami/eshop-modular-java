package org.eshop.eshop.user.domain.entities;

import jakarta.persistence.*;
import org.eshop.eshop.user.domain.valueObjects.Email;
import org.eshop.eshop.user.domain.valueObjects.Password;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(UUID id, String name, Email email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email.toString();
        this.password = password.toString();
    }

    public static User createNew(String name, Email email, Password password) {
        return new User(null, name, email, password);
    }

    public static User withId(UUID id, String name, Email email, Password password) {
        return new User(id, name, email, password);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
