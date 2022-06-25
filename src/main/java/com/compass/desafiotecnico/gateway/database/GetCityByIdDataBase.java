package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCityByIdGateway;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import org.springframework.stereotype.Component;

@Component
public class GetCityByIdDataBase implements GetCityByIdGateway {

    private CityRepository cityRepository;

    public GetCityByIdDataBase(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City execute(Long id) throws RuntimeException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City Not Found"))
                .translateToDomain();


    }
}

