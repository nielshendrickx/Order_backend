package com.switchfully.order.api.endpoints;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.order.service.Views;
import com.switchfully.order.service.user.UserService;
import com.switchfully.order.service.user.customer.CreateCustomerDto;
import com.switchfully.order.service.user.customer.CustomerDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(path = CustomerController.CUSTOMER_RESOURCE_PATH)
public class CustomerController {
    public static final String CUSTOMER_RESOURCE_PATH = "/customer";
    private final Logger loggerUser = LoggerFactory.getLogger(CustomerController.class);
    private final UserService userService;

    @Autowired
    public CustomerController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(Views.Public.class)
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register as a customer", notes = "Everyone can freely join Eurder!", response = CustomerDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto registerCustomer(@RequestBody CreateCustomerDto newCustomer) throws IOException {
        loggerUser.info("Registering a new customer.");
        return userService.registerCustomer(newCustomer);
    }

    @PreAuthorize("hasAuthority('VIEW_CUSTOMERS')")
    @JsonView(Views.Admin.class)
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Find all registered customers", notes = "Get a list of all registered customers.", response = CustomerDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<CustomerDto> getAllCustomers() {
        loggerUser.info("Getting all the registered customers.");
        return userService.getAllCustomers();
    }

    @PreAuthorize("hasAuthority('VIEW_CUSTOMERS')")
    @JsonView(Views.Admin.class)
    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Find customer by id", notes = "Get a registered customer.", response = CustomerDto.class)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getACustomer(Authentication authentication, @ApiParam(value = "ID value for the member you need to retrieve", required = true) @PathVariable String id) {
        loggerUser.info("Getting a registered customer.");
        System.out.println("User: " + authentication.getName());
        return userService.getCustomer(id);
    }
}
