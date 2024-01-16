package com.folksdev.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String surname;
    private Set<CustomerAccountDto> accounts;


}
