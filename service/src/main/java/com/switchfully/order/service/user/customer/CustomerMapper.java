package com.switchfully.order.service.user.customer;

import com.switchfully.order.domain.user.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Collection<CustomerDto> toDto(Collection<Customer> customerCollection) {
        return customerCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPassword(), customer.getAddress(), customer.getPhoneNumber(), customer.getDateJoined());
    }

    public Customer toCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(), createCustomerDto.getPassword(), createCustomerDto.getAddress(), createCustomerDto.getPhoneNumber());
    }
}
