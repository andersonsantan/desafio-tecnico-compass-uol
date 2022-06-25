package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.client.Client;

public interface GetClientByIdGateway {
    Client execute(Long id);
}
