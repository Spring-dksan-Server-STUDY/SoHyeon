package com.dksanServer.sohyeon.week7;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(String name, int age, String email) {
        Customer customer = new Customer(UUID.randomUUID(), name, age, email, LocalDateTime.now());
        return customerRepository.insert(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomer(String name, int age, String email) {
        return null;
    }

    @Override
    public void deleteAllCustomers() {

    }
}
