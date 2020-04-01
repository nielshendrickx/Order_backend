package com.switchfully.order.domain.user;

import com.switchfully.order.domain.DummyData;
import com.switchfully.order.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.order.domain.exceptions.CustomerNotFoundException;
import com.switchfully.order.domain.user.customer.Customer;
import com.switchfully.order.domain.user.system.security.Role;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<String, User> userRepository;
    private final DummyData dummyData;

    public UserRepository(DummyData dummyData) {
        this.userRepository = new ConcurrentHashMap<>();
        this.dummyData = dummyData;
        addDefaultData();
    }

    public boolean isEmailAvailable(String email) {
        if (userRepository.values().stream()
                .anyMatch(member -> member.getEmail().equals(email))) {
            throw new EmailAlreadyRegisteredException(email);
        }
        return true;
    }

    public User addUser(User newUser) {
        userRepository.put(newUser.getId(), newUser);
        return newUser;
    }

    public Collection<Customer> getAllCustomers() {
        return userRepository.values().stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .map(customer -> (Customer) customer)
                .collect(Collectors.toList());
    }

    public Customer findCustomerById(String id) {
        return (Customer) userRepository.values().stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .filter(searchedUser -> id.equals(searchedUser.getId()))
                .findAny()
                .orElseThrow(CustomerNotFoundException::new);
    }

    private void addDefaultData() {
        for(User user : dummyData.getDefaultUsers()) {
            addUser(user);
        }
    }

}
