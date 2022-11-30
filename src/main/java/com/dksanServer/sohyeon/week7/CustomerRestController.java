package com.dksanServer.sohyeon.week7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(
                createCustomerRequest.name(),
                createCustomerRequest.age(),
                createCustomerRequest.email()
        );
    }

    @GetMapping("/api/v1/customer/{customerId}")
    @ResponseBody
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") String customerId) {
        Optional<Customer> customer = customerService.getCustomerById(UUID.fromString(customerId));
        return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
