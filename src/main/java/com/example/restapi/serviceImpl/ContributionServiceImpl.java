package com.example.restapi.serviceImpl;

import com.example.restapi.model.Contribution;
import com.example.restapi.repository.ContributionRepository;
import com.example.restapi.repository.specification.ContributionSpecification;
import com.example.restapi.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
@Repository
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;

    @Override
    public List<Contribution> getAll(Contribution contribution, Sort sort) {
        return contributionRepository.findAll(new ContributionSpecification(contribution), sort);
    }

    @Override
    public Contribution getById(Long id) {
        return contributionRepository.findOne(id);
    }

    @Override
    public Contribution save(Contribution contribution) {
        return contributionRepository.save(contribution);
    }

    @Override
    public Contribution update(Contribution contribution) {
        return contributionRepository.saveAndFlush(contribution);
    }

    @Override
    public void remove(Long id) {
        contributionRepository.delete(id);
    }
}
