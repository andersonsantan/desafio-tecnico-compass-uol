package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCityByNameAndStateGateway;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import org.springframework.stereotype.Component;


@Component
public class GetCityByNameAndStateDatabase implements GetCityByNameAndStateGateway {
    private CityRepository repository;

    public GetCityByNameAndStateDatabase(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City execute(String name, String state) {
      return repository.findByNameAndState(name, state)
              .orElseThrow(()-> new RuntimeException("City Not Found"))
              .translateToDomain();
    }

}
