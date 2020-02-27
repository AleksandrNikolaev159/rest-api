package com.example.restapi.serviceImpl;

import com.example.restapi.model.Client;
import com.example.restapi.repository.ClientRepository;
import com.example.restapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll(Client client, Sort sort) {
        return clientRepository.findAll();
    }

    @Override
    public Client geByID(long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void remove(long id) {
        clientRepository.delete(id);
    }
}
