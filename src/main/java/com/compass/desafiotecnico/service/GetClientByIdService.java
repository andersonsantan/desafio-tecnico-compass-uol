package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.GetClientByIdGateway;
import com.compass.desafiotecnico.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class GetClientByIdService {
    GetClientByIdGateway getClientByIdGateway;

    public GetClientByIdService(GetClientByIdGateway getClientByIdGateway) {
        this.getClientByIdGateway = getClientByIdGateway;
    }

    public Client execute(Long id) {
        try {
            return getClientByIdGateway.execute(id);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }
}
