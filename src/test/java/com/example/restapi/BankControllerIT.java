package com.example.restapi;

import com.example.restapi.model.Bank;
import com.example.restapi.service.BankService;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class)
public class BankControllerIT {

    @Autowired
    BankService controller;

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getBanks() throws Exception{
        ResponseEntity<Collection<Bank>> responseEntity =
                restTemplate.exchange("http://localhost:8080/banks", HttpMethod.GET, null,
        new ParameterizedTypeReference<Collection<Bank>>() {
        });

        Collection<Bank> actualList = responseEntity.getBody();

        //validate
        assertThat(actualList.size(), is(controller.getAll(new Bank(),new Sort("id")).size()));

        List<Long> actualIds = actualList.stream()
                .map(bank -> bank.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        List<Long> list = new ArrayList<>();
        for(long i=0;i <= actualList.size();i++){
            list.add(i);
        }

        assertThat(actualIds,is(list));

    }


}
