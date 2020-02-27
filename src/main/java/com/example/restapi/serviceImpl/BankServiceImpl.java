package com.example.restapi.serviceImpl;

import com.example.restapi.model.Bank;
import com.example.restapi.repository.BankRepository;
import com.example.restapi.repository.specification.BankSpecification;
import com.example.restapi.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
@Repository
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAll(Bank bank, Sort sort) {

        return bankRepository.findAll(new BankSpecification(bank), sort);
    }

    @Override
    public Bank getByID(Long id) {
        return bankRepository.findOne(id);
    }

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Bank bank) { return bankRepository.saveAndFlush(bank); }

    @Override
    public void remove(Long id) { bankRepository.delete(id);

    }

}
