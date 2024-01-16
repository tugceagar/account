package com.folksdev.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";

    private BigDecimal balance = BigDecimal.ZERO;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transaction = new HashSet();

    public Account(Customer customer, BigDecimal initialCredit, LocalDateTime now) {
        this.customer = customer;
        this.balance =  initialCredit ;
        this.creationDate = now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id)
                && Objects.equals(balance, account.balance)
                && Objects.equals(creationDate, account.creationDate)
                && Objects.equals(customer, account.customer)
                && Objects.equals(transaction, account.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, creationDate, customer);
    }
}
