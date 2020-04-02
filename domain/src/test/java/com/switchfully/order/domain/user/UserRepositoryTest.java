package com.switchfully.order.domain.user;

import com.switchfully.order.domain.DummyData;
import com.switchfully.order.domain.exceptions.AuthenticationFailedException;
import com.switchfully.order.domain.exceptions.CustomerNotFoundException;
import com.switchfully.order.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.customer.Customer;
import com.switchfully.order.domain.user.system.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    DummyData dummyData = new DummyData();
    UserRepository userRepository = new UserRepository(dummyData);

    @Test
    void ifEmail_doesntExist_returnTrue() {
        assertTrue(userRepository.isEmailAvailable("test@test.com"));
    }

    @Test
    void addUser_shouldBeAddedToRepo() {
        Customer customer = new Customer("FirstName", "LastName", "testcustomer@test.com", "password", new Address("A Street", "10B", "3300", "Tienen"),"+32473000000");
        userRepository.registerCustomer(customer);
        assertTrue(userRepository.getAllCustomers().contains(customer));
    }

    @Test
    void ifEmail_doesExist_throwEmailException() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", "password");
        userRepository.registerAdmin(admin);
        assertThrows(EmailAlreadyRegisteredException.class, () -> userRepository.isEmailAvailable("test@test.com"));
    }

    @Test
    void findCustomerById_ShouldReturnCustomer() {
        Customer customer = new Customer("FirstName", "LastName", "testcustomer@test.com", "password", new Address("A Street", "10B", "3300", "Tienen"),"+32473000000");
        userRepository.registerCustomer(customer);
        assertEquals(customer, userRepository.findCustomerById(customer.getId()));
    }

    @Test
    void findCustomerById_whenNotFoundShouldThrowException() {
        Customer customer = new Customer("FirstName", "LastName", "testcustomer@test.com", "password", new Address("A Street", "10B", "3300", "Tienen"),"+32473000000");
        assertThrows(CustomerNotFoundException.class, () -> userRepository.findCustomerById(customer.getId()));
    }

    @Test
    void authenticate_succes_shouldReturnUser() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", "password");
        userRepository.registerAdmin(admin);
        assertEquals(admin, userRepository.authenticate("test@test.com", "password"));
    }

    @Test
    void authenticate_failed_ShouldThrowAuthException() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", "password");
        userRepository.registerAdmin(admin);
        assertThrows(AuthenticationFailedException.class, () -> userRepository.authenticate("test@test.com", "awrongpassword"));
    }
}