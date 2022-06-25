package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.client.Client;

import java.util.List;

public interface GetClientByNameGateway {
    List<Client> execute(String name);
}
