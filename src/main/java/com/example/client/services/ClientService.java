package com.example.client.services;

import com.example.client.domain.ClientDTO;
import com.example.client.domain.ClientKpiDTO;

import java.util.List;

public interface ClientService {
    void save(ClientDTO value);
    List<ClientDTO> list();
    ClientKpiDTO calculateKpi();
}
