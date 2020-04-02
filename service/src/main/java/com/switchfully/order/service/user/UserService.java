package com.switchfully.order.service.user;

import com.switchfully.order.domain.user.UserRepository;
import com.switchfully.order.service.user.customer.CreateCustomerDto;
import com.switchfully.order.service.user.customer.CustomerDto;
import com.switchfully.order.service.user.customer.CustomerMapper;
import com.switchfully.order.service.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class UserService {
    private UserRepository userRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public UserService(UserRepository userRepository, CustomerMapper customerMapper) {
        this.userRepository = userRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto registerCustomer(CreateCustomerDto newCustomer) throws IOException {
        validateNewCustomer(newCustomer.getEmail());
        return customerMapper.toDto(userRepository.registerCustomer(customerMapper.toCustomer(newCustomer)));
    }

    public Collection<CustomerDto> getAllCustomers() {
        return customerMapper.toDto(userRepository.getAllCustomers());
    }

    public CustomerDto getCustomer(String id) {
        return customerMapper.toDto(userRepository.findCustomerById(id));
    }

    private boolean isEmailAvailable(String email) {
        return userRepository.isEmailAvailable(email);
    }

    private void validateNewCustomer(String email) throws IOException {
        Validation.isValidEmailAddress(email);
        isEmailAvailable(email);
    }
}
