package com.switchfully.order.service.user.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.system.security.Role;
import com.switchfully.order.service.user.CreateUserDto;

import java.time.LocalDate;

public class CreateCustomerDto extends CreateUserDto {
    private final Address address;
    private final String phoneNumber;
    private final LocalDate dateJoined;

    @JsonCreator
    public CreateCustomerDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("address") Address address, @JsonProperty("phoneNumber") String phoneNumber) {
        super(firstName, lastName, email, password, Role.CUSTOMER);
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
