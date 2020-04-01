package com.switchfully.order.domain;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.customer.Address;
import com.switchfully.order.domain.user.customer.Customer;
import com.switchfully.order.domain.user.system.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
    List<User> defaultUsers = new ArrayList<>();

    public DummyData() {
        Admin niels = new Admin("Niels", "Hendrickx", "niels@order.com", "root");
        Customer john = new Customer("John", "Doe", "john@order.com", "john", new Address("A Street", "10B", "3300", "Tienen"),"+32473000000");
        Customer kris = new Customer("Kris", "Appeltans", "kris@order.com", "kris", new Address("A Second Street", "11B", "3300", "Tienen"),"+32473111111");
        Customer clodine = new Customer("Clodine", "Van Peer", "clodine@order.com", "clodine", new Address("A Thirth Street", "12B", "3300", "Tienen"),"+32473222222");

        defaultUsers.add(niels);
        defaultUsers.add(john);
        defaultUsers.add(kris);
        defaultUsers.add(clodine);
    }

    public List<User> getDefaultUsers() {
        return defaultUsers;
    }
}
