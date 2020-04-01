package com.switchfully.order.domain.user.customer;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public class Address {
    private final String id = UUID.randomUUID().toString();
    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    @JsonCreator
    public Address(String street, String streetNumber, String postalCode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
