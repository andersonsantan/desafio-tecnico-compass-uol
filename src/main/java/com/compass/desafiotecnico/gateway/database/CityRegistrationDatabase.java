package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.CityRegistrationGateway;
import com.compass.desafiotecnico.gateway.GetCitiesByNameGateway;
import com.compass.desafiotecnico.gateway.database.model.CityDatabase;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class CityRegistrationDatabase implements CityRegistrationGateway {
    private CityRepository cityRepository;
    private GetCitiesByNameGateway getCityesByNameGateway;

    public CityRegistrationDatabase(CityRepository cityRepository, GetCitiesByNameGateway getCityesByNameGateway) {
        this.cityRepository = cityRepository;
        this.getCityesByNameGateway = getCityesByNameGateway;
    }

    @Override
    public City execute(City city)  {
        List<City> cities = getCityesByNameGateway.execute(city.getName());
        if (cities.contains(city)) {
            log.error("City already registered");
            throw new RuntimeException("City already registered");
        }
        return cityRepository
                .save(CityDatabase.translateToModel(city))
                .translateToDomain();
    }
}
