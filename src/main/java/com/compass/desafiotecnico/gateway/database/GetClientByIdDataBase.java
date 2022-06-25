package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.GetCityByIdGateway;
import com.compass.desafiotecnico.gateway.GetClientByIdGateway;
import com.compass.desafiotecnico.gateway.database.model.ClientDatabase;
import com.compass.desafiotecnico.gateway.database.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class GetClientByIdDataBase implements GetClientByIdGateway {

    private ClientRepository clientRepository;
    private GetCityByIdGateway getCityByIdGateway;

    public GetClientByIdDataBase(ClientRepository clientRepository, GetCityByIdGateway getCityByIdGateway) {
        this.clientRepository = clientRepository;
        this.getCityByIdGateway = getCityByIdGateway;
    }

    @Override
    public Client execute(Long id) throws RuntimeException{
        ClientDatabase getClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client Not Found"));
        City city = getCityByIdGateway.execute(getClient.getCityId());
        return getClient.translateToDomain(city);

    }
}

