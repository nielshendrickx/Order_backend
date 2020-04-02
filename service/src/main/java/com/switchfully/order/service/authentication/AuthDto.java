package com.switchfully.order.service.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.order.domain.user.system.security.Role;
import com.switchfully.order.service.Views;

import java.util.Objects;

public class AuthDto {
    @JsonView(Views.Internal.class)
    private String email;
    @JsonView(Views.Admin.class)
    private Role role;
    @JsonView(Views.Internal.class)
    private String password;

    @JsonCreator
    public AuthDto(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("role") Role role) {
        this.email = email;
        this.role = role;
        this.password = password;
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
        AuthDto authDto = (AuthDto) o;
        return Objects.equals(email, authDto.email) &&
                role == authDto.role &&
                Objects.equals(password, authDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role, password);
    }
}
