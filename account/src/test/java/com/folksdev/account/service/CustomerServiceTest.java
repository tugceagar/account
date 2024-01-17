package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDtoConverter;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter customerDtoConverter;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock(CustomerDtoConverter.class);
        customerService = new CustomerService(customerRepository,customerDtoConverter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Customer result = customerService.findById("id");

        assertEquals(result, customer);
    }

}