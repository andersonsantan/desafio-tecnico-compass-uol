package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.ClientRegistrationGateway;
import com.compass.desafiotecnico.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationService {

    private ClientRegistrationGateway clientRegistrationGateway;

    public ClientRegistrationService(ClientRegistrationGateway clientRegistrationGateway) {
        this.clientRegistrationGateway = clientRegistrationGateway;
    }

    public Client execute(Client client){
        try {
            return clientRegistrationGateway.execute(client);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
