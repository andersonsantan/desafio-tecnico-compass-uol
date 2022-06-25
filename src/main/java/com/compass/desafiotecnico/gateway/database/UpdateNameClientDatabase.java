package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.UpdateNameClientGateway;
import com.compass.desafiotecnico.gateway.database.model.ClientDatabase;
import com.compass.desafiotecnico.gateway.database.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateNameClientDatabase implements UpdateNameClientGateway {

    ClientRepository clientRepository;

    public UpdateNameClientDatabase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(Client client) throws RuntimeException{
            clientRepository.save(ClientDatabase.translateToModel(client,client.getCityId()));

    }
}
