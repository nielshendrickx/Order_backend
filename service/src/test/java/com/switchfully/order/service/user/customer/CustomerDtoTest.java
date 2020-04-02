package com.switchfully.order.service.user.customer;

import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    @Test
    void customerDto_returnsCorrectValues() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CustomerDto customerDto = new CustomerDto("id", "John", "Doe", "john@doe.com", "aPassword", address, "+32473000000", LocalDate.now());
        assertEquals("id", customerDto.getId());
        assertEquals("John", customerDto.getFirstName());
        assertEquals("Doe", customerDto.getLastName());
        assertEquals("john@doe.com", customerDto.getEmail());
        assertEquals("aPassword", customerDto.getPassword());
        assertEquals(address, customerDto.getAddress());
        assertEquals(Role.CUSTOMER, customerDto.getRole());
        assertEquals("+32473000000", customerDto.getPhoneNumber());
        assertEquals(LocalDate.now(), customerDto.getDateJoined());
    }
}