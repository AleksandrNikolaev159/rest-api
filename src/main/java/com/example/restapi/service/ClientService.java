package com.example.restapi.service;

import com.example.restapi.model.Client;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ClientService {

    List<Client> getAll(Client client, Sort sort);
    Client geByID(long id);
    Client save(Client client);
    Client update(Client client);
    void remove(long id);
}
