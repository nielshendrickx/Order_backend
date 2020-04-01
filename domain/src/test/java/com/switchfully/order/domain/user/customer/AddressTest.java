package com.switchfully.order.domain.user.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void createAddress_shouldReturnCorrectValues() {
        Address address = new Address("A street", "10B", "3300", "Tienen");
        assertNotNull(address.getId());
        assertEquals("A street", address.getStreet());
        assertEquals("10B", address.getStreetNumber());
        assertEquals("3300", address.getPostalCode());
        assertEquals("Tienen", address.getCity());
    }
}