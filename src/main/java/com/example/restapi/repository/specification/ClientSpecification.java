package com.example.restapi.repository.specification;

import com.example.restapi.model.Client;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClientSpecification implements Specification<Client> {

    public final Client client;

    public ClientSpecification(Client client) {
        this.client = client;
    }

    @Override
    public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(client.getId()!=null){
            predicates.add(criteriaBuilder.equal(root.get("id"), client.getId()));
        }
        if (client.getName() != null){
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + client.getName().toUpperCase() + "%"));
        }
        if (client.getShortName() != null){
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("shortName")), "%" + client.getShortName().toUpperCase() + "%"));
        }
        if (client.getAddress() != null){
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("address")), "%" + client.getAddress().toUpperCase() + "%"));
        }
        if(client.getLegalOrganizationForm() !=null){
            predicates.add(criteriaBuilder.equal(root.get("legalOrganizationForm"),client.getLegalOrganizationForm()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
