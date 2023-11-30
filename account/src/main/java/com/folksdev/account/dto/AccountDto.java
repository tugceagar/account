package com.folksdev.account.dto;

import com.folksdev.account.model.Customer;
import com.folksdev.account.model.Transaction;
import org.hibernate.mapping.Set;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountDto {
    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private CustomerDto customer;
    private Set<TransactionDto> transactions;
}
