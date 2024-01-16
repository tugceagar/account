package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.dto.CustomerDtoConverter;
import com.folksdev.account.exception.CustomerNotFoundException;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findById (String id){
        return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer could not found by id: " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findById(customerId));
    }
}
