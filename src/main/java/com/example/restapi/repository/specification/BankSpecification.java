package com.example.restapi.repository.specification;

import com.example.restapi.model.Bank;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BankSpecification implements Specification<Bank> {

    private final Bank bank;

    public BankSpecification(Bank bank) {
        this.bank = bank;
    }


    @Override
    public Predicate toPredicate(Root<Bank> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (bank.getId() !=null){
            predicates.add(criteriaBuilder.equal(root.get("id"), bank.getId()));
        }
        if (bank.getName() != null){
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + bank.getName().toUpperCase() + "%"));
        }
        if (bank.getBik() !=null){
            predicates.add(criteriaBuilder.equal(root.get("bik"), bank.getBik()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
