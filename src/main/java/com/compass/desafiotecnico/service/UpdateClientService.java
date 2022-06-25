package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.GetClientByIdGateway;
import com.compass.desafiotecnico.gateway.UpdateNameClientGateway;
import com.compass.desafiotecnico.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientService {
    UpdateNameClientGateway updateNameClientGateway;
    GetClientByIdGateway getClientByIdGateway;

    public UpdateClientService(UpdateNameClientGateway updateNameClientGateway, GetClientByIdGateway getClientByIdGateway) {
        this.updateNameClientGateway = updateNameClientGateway;
        this.getClientByIdGateway = getClientByIdGateway;
    }

    public void execute(Long id, String name) {
        try {
            Client client = getClientByIdGateway.execute(id);
            client.setName(name);
            updateNameClientGateway.execute(client);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }
}
