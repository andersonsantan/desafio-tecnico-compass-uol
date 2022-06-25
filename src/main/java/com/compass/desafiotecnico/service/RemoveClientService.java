package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.gateway.RemoveClientGateway;
import org.springframework.stereotype.Service;

@Service
public class RemoveClientService {
    RemoveClientGateway removeClientGateway;

    public RemoveClientService(RemoveClientGateway removeClientGateway) {
        this.removeClientGateway = removeClientGateway;
    }


    public void execute(Long id) {
        removeClientGateway.execute(id);
    }
}
