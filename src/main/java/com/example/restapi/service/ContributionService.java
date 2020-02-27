package com.example.restapi.service;
import com.example.restapi.model.Contribution;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ContributionService {

    List<Contribution> getAll(Contribution contribution, Sort sort);
    Contribution getById(Long id);
    Contribution save(Contribution contribution);
    Contribution update(Contribution contribution);
    void remove(Long id);

}
