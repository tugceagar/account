package com.folksdev.account.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> accounts;
}