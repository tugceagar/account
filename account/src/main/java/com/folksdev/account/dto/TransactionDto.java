package com.folksdev.account.dto;

import com.folksdev.account.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String id;
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
