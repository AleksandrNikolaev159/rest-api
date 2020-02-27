package com.example.restapi.service;

import com.example.restapi.model.Bank;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BankService {

    List<Bank> getAll(Bank bank, Sort sort);
    Bank getByID(Long id);
    Bank save(Bank bank);
    Bank update(Bank bank);
    void  remove(Long id);
}
