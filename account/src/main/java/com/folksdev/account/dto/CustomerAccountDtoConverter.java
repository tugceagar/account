package com.folksdev.account.dto;

import com.folksdev.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account account){
        return new CustomerAccountDto(
                account.getId(),
                account.getBalance(),
                account.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()),
                account.getCreationDate()
                );
    }
}
