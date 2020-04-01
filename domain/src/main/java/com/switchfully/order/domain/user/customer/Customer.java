package com.switchfully.order.domain.user.customer;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.system.security.Role;

import java.time.LocalDate;

public class Customer extends User {
    private final Address address;
    private final String phoneNumber;
    private final LocalDate dateJoined;

    public Customer(String firstName, String lastName, String email, String password, Address address, String phoneNumber) {
        super(firstName, lastName, email, Role.CUSTOMER,password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateJoined = LocalDate.now();
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }
}
