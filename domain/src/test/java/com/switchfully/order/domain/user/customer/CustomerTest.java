package com.switchfully.order.domain.user.customer;

import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void createCustomer_shouldReturnCorrectValues() {
        Customer customer = new Customer("John", "Doe", "john@doe.com", "aPassword", new Address("aStreet", "10B", "3300", "Tienen"), "+32473000000");
        assertNotNull(customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john@doe.com", customer.getEmail());
        assertEquals(LocalDate.now(), customer.getDateJoined());
        assertNotNull(customer.getAddress().getId());
        assertEquals("aStreet", customer.getAddress().getStreet());
        assertEquals("10B", customer.getAddress().getStreetNumber());
        assertEquals("3300", customer.getAddress().getPostalCode());
        assertEquals("Tienen", customer.getAddress().getCity());
        assertEquals("+32473000000", customer.getPhoneNumber());
    }

    @Test
    void createCustomer_getRole_shouldReturnCustomer()
    {
        Customer customer = new Customer("John", "Doe", "john@doe.com", "aPassword", new Address("aStreet", "10B", "3300", "Tienen"), "+32473000000");
        assertEquals(Role.CUSTOMER, customer.getRole());
    }
}