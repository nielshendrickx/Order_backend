package com.switchfully.order.service.user.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.system.security.Role;
import com.switchfully.order.service.user.UserDto;

import java.time.LocalDate;

public class CustomerDto extends UserDto {
    private final Address address;
    private final String phoneNumber;
    private final LocalDate dateJoined;

    @JsonCreator
    public CustomerDto(@JsonProperty("id") String id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("address") Address address, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("dateJoined") LocalDate dateJoined) {
        super(id, firstName, lastName, email, password, Role.CUSTOMER);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateJoined = dateJoined;
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
