package com.switchfully.order.domain.user;

import com.switchfully.order.domain.user.system.security.Hash;
import com.switchfully.order.domain.user.system.security.Role;

import java.util.Objects;
import java.util.UUID;

public abstract class User {
    private final String id = UUID.randomUUID().toString();
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Role role;
    private final String password;

    public User(String firstName, String lastName, String email, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = Hash.hash(password);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
