package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.gateway.ClientRegistrationGateway;
import com.compass.desafiotecnico.gateway.GetCityByNameAndStateGateway;
import com.compass.desafiotecnico.gateway.database.model.ClientDatabase;
import com.compass.desafiotecnico.gateway.database.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientRegistrationDataBase implements ClientRegistrationGateway {

    ClientRepository clientRepository;
    GetCityByNameAndStateGateway getCityByNameAndStateGateway;

    public ClientRegistrationDataBase(ClientRepository clientRepository, GetCityByNameAndStateGateway getCityByNameAndStateGateway) {
        this.clientRepository = clientRepository;
        this.getCityByNameAndStateGateway = getCityByNameAndStateGateway;
    }

    @Override
    public Client execute(Client client) {
        City city = getCityByNameAndStateGateway.execute(client.getNameCity(), client.getNameState());
        ClientDatabase entity = ClientDatabase.translateToModel(client, city.getId());
        return clientRepository.save(entity).translateToDomain(city);
    }
}
