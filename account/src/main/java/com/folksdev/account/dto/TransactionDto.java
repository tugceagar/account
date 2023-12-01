package com.folksdev.account.dto;

import com.folksdev.account.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private String id;
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
