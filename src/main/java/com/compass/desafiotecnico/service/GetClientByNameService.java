package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.GetClientByIdGateway;
import com.compass.desafiotecnico.gateway.GetClientByNameGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientByNameService {

    GetClientByNameGateway getClientByNameGateway;
    GetClientByIdGateway getClientByIdGateway;

    public GetClientByNameService(GetClientByNameGateway getClientByNameGateway, GetClientByIdGateway getClientByIdGateway) {
        this.getClientByNameGateway = getClientByNameGateway;
        this.getClientByIdGateway = getClientByIdGateway;
    }

    public List<Client> execute(String name) {
            return getClientByNameGateway.execute(name);
    }
}
