package com.switchfully.order.service.user.customer;

import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreateCustomerDtoTest {
    @Test
    void createCustomerDto_returnsCorrectValues() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("John", "Doe", "john@doe.com", "aPassword", address, "+32473000000");
        assertEquals("John", createCustomerDto.getFirstName());
        assertEquals("Doe", createCustomerDto.getLastName());
        assertEquals("john@doe.com", createCustomerDto.getEmail());
        assertEquals("aPassword", createCustomerDto.getPassword());
        assertEquals(address, createCustomerDto.getAddress());
        assertEquals(Role.CUSTOMER, createCustomerDto.getRole());
        assertEquals("+32473000000", createCustomerDto.getPhoneNumber());
        assertEquals(LocalDate.now(), createCustomerDto.getDateJoined());
    }
}