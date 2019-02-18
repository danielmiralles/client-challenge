package com.example.client.services.impl;

import com.example.client.domain.ClientDTO;
import com.example.client.domain.ClientKpiDTO;
import com.example.client.domain.ClientPersitent;
import com.example.client.helpers.Statistics;
import com.example.client.repositories.ClientRepository;
import com.example.client.services.ClientService;
import com.example.client.services.DeathDateCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;
    private DeathDateCalculator deathDateCalculator;

    public ClientServiceImpl(ClientRepository repository, DeathDateCalculator deathDateCalculator) {
        this.repository = repository;
        this.deathDateCalculator = deathDateCalculator;
    }

    protected List<ClientDTO> getAll() {
        List<ClientDTO> clientList = new ArrayList<>();
        this.repository.findAll().forEach(x -> clientList.add(new ClientDTO(x)));
        return clientList;
    }

    @Override
    public void save(ClientDTO value) {
        repository.save(new ClientPersitent(deathDateCalculator.predictDate(value)));
    }


    @Override
    public List<ClientDTO> list() {
        return getAll();
    }

    @Override
    public ClientKpiDTO calculateKpi() {
        return Statistics.computeStatistics(getAll().stream().map(x -> x.getAge()).collect(Collectors.toList()));
    }
}
