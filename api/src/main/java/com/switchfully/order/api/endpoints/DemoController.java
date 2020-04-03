package com.switchfully.order.api.endpoints;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = DemoController.DEMO_RESOURCE_PATH)
public class DemoController {
    public static final String DEMO_RESOURCE_PATH = "/demo";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getAllCustomers() {
        return "Hello world!";
    }
}
