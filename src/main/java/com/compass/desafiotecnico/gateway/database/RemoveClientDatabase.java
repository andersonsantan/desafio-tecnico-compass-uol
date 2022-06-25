package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.gateway.RemoveClientGateway;
import com.compass.desafiotecnico.gateway.database.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class RemoveClientDatabase implements RemoveClientGateway {

    ClientRepository clientRepository;

    public RemoveClientDatabase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(Long id) {
        clientRepository.deleteById(id);
    }
}
