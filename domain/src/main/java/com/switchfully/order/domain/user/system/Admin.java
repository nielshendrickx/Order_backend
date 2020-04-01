package com.switchfully.order.domain.user.system;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.system.security.Role;

public class Admin extends User {

    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, Role.ADMIN ,password);
    }
}
