package com.switchfully.order.service.user;

import com.switchfully.order.domain.DummyData;
import com.switchfully.order.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.order.domain.exceptions.EmailNotValidException;
import com.switchfully.order.domain.exceptions.NameNotValidException;
import com.switchfully.order.domain.user.UserRepository;
import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.service.user.customer.CreateCustomerDto;
import com.switchfully.order.service.user.customer.CustomerMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceTest {

    DummyData dummyData = new DummyData();
    CustomerMapper customerMapper = new CustomerMapper();
    UserRepository userRepository = new UserRepository(dummyData);
    UserService userService = new UserService(userRepository, customerMapper);

    @Test
    void createCustomerValid_thenContinue() throws IOException {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("John", "Doe", "john@doe.com", "aPassword", address, "+32473000000");
        userService.registerCustomer(createCustomerDto);
    }

    @Test
    void createUnvalidEmailCustomer_shouldThrowEmailNotValidException() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("John", "Doe", "johndoe.com", "aPassword", address, "+32473000000");
        assertThrows(EmailNotValidException.class, () ->userService.registerCustomer(createCustomerDto));
    }

    @Test
    void createExistingEmailCustomer_shouldThrowEmailNotValidException() throws IOException {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("John", "Doe", "joh@ndoe.com", "aPassword", address, "+32473000000");
        userService.registerCustomer(createCustomerDto);
        assertThrows(EmailAlreadyRegisteredException.class, () ->userService.registerCustomer(createCustomerDto));
    }

    @Test
    void createUnvalidNameCustomer_shouldThrowNameNotValidException() {
        Address address = new Address("aStreet", "10B", "3300", "Tienen");
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("Jo-hn", "Doe", "joh@ndoe.com", "aPassword", address, "+32473000000");
        assertThrows(NameNotValidException.class, () -> userService.registerCustomer(createCustomerDto));
    }


}