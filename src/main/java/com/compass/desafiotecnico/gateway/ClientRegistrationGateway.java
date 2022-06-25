package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.client.Client;

public interface ClientRegistrationGateway {
    Client execute(Client client);
}
