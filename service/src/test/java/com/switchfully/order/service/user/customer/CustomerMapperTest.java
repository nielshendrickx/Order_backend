package com.switchfully.order.service.user.customer;

import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.customer.Customer;
import com.switchfully.order.domain.user.system.security.Hash;
import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    CustomerMapper customerMapper = new CustomerMapper();

    @Test
    void  mappingToCustomer_returnsMemberWithSameValuesAsCreateCustomerDto() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        Customer customer = customerMapper.toCustomer(new CreateCustomerDto("John", "Doe", "john@doe.com", "aPassword", address, "+32473000000"));
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john@doe.com", customer.getEmail());
        assertTrue(Hash.verifyHash("aPassword", customer.getPassword()));
        assertEquals(address, customer.getAddress());
        assertEquals(Role.CUSTOMER, customer.getRole());
        assertEquals("+32473000000", customer.getPhoneNumber());
        assertEquals(LocalDate.now(), customer.getDateJoined());
    }

    @Test
    void mappingToDto_returnsDtoWithSameValuesAsCustomer() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        Customer customer = new Customer("John", "Doe", "john@doe.com", "aPassword", address, "+32473000000");
        CustomerDto customerDto = customerMapper.toDto(customer);
        assertEquals(customer.getId(), customerDto.getId());
        assertEquals("John", customerDto.getFirstName());
        assertEquals("Doe", customerDto.getLastName());
        assertEquals("john@doe.com", customerDto.getEmail());
        assertTrue(Hash.verifyHash("aPassword", customerDto.getPassword()));
        assertEquals(address, customerDto.getAddress());
        assertEquals(Role.CUSTOMER, customerDto.getRole());
        assertEquals("+32473000000", customerDto.getPhoneNumber());
        assertEquals(LocalDate.now(), customerDto.getDateJoined());
    }

    @Test
    void mappingToDtoCollection__returnsMemberWithSameValuesAsCreateCustomerDto() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        Customer customer = new Customer("John", "Doe", "john@doe.com", "aPassword", address, "+32473000000");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        Collection<CustomerDto> customerDtoList = customerMapper.toDto(customerList);
        assertEquals(customer.getId(), customerDtoList.iterator().next().getId());
        assertEquals("John", customerDtoList.iterator().next().getFirstName());
        assertEquals("Doe", customerDtoList.iterator().next().getLastName());
        assertEquals("john@doe.com", customerDtoList.iterator().next().getEmail());
        assertTrue(Hash.verifyHash("aPassword", customerDtoList.iterator().next().getPassword()));
        assertEquals(address, customerDtoList.iterator().next().getAddress());
        assertEquals(Role.CUSTOMER, customerDtoList.iterator().next().getRole());
        assertEquals("+32473000000", customerDtoList.iterator().next().getPhoneNumber());
        assertEquals(LocalDate.now(), customerDtoList.iterator().next().getDateJoined());
    }



}