package com.folksdev.account.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class AccountDto {
    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto customer;
    private Set<TransactionDto> transactions;
}
