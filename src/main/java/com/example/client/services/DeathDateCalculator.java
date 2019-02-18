package com.example.client.services;

import com.example.client.domain.ClientDTO;

public interface DeathDateCalculator {
    ClientDTO predictDate(ClientDTO value);
}
