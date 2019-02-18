package com.example.client.controllers;

import com.example.client.domain.ClientDTO;
import com.example.client.domain.ClientKpiDTO;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        clientService.save(clientDTO);
        return clientDTO;
    }

    @GetMapping
    public List<ClientDTO> list() {
        return clientService.list();
    }

    @GetMapping(path = "kpi")
    public ClientKpiDTO calculateKpi() {
        return clientService.calculateKpi();
    }
}
