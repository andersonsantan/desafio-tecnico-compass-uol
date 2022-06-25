package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.GetCityByIdGateway;
import com.compass.desafiotecnico.gateway.GetClientByNameGateway;
import com.compass.desafiotecnico.gateway.database.model.ClientDatabase;
import com.compass.desafiotecnico.gateway.database.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientByNameDataBase implements GetClientByNameGateway {

    private ClientRepository clientRepository;
    private GetCityByIdGateway getCityByIdGateway;

    public GetClientByNameDataBase(ClientRepository clientRepository, GetCityByIdGateway getCityByIdGateway) {
        this.clientRepository = clientRepository;
        this.getCityByIdGateway = getCityByIdGateway;
    }

    @Override
    public List<Client> execute(String name) {
        List<ClientDatabase> clientsOfDataBase = clientRepository.findAllByName(name);
        List<Client> clients = new ArrayList<>();
        clientsOfDataBase.forEach(e -> {
            Client client = e.translateToDomain(getCityByIdGateway.execute(e.getCityId()));
            clients.add(client);
        });

        return clients;

    }
}
