package com.folksdev.account.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {
    @NotBlank(message = "Customer id cannot be empty")
    private String customerId;
    @Min(value = 0, message = "Credit cannot be negative")
    private BigDecimal initialCredit;


}