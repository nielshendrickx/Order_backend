package com.switchfully.order.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.order.domain.user.system.security.Role;
import com.switchfully.order.service.Views;

public abstract class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonView(Views.Admin.class)
    private Role role;
    @JsonView(Views.Internal.class)
    private String password;

    @JsonCreator
    public UserDto(@JsonProperty("id") String id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("role") Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
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
}
