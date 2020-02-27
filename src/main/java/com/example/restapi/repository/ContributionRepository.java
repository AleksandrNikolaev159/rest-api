package com.example.restapi.repository;

import com.example.restapi.model.Contribution;
import com.example.restapi.repository.specification.ContributionSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface ContributionRepository extends JpaRepository<Contribution, Long> , JpaSpecificationExecutor<Contribution> {


}
