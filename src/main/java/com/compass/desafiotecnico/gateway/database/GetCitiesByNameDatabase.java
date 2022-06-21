package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCitiesByNameGateway;
import com.compass.desafiotecnico.gateway.database.model.CityDatabase;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class GetCitiesByNameDatabase implements GetCitiesByNameGateway {
    private CityRepository repository;

    public GetCitiesByNameDatabase(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> execute(String nameCity) {
        List<CityDatabase> cityesDatabase = repository.findAllByName(nameCity);
        return translateAllModelToDomain(cityesDatabase);
    }

    private List<City> translateAllModelToDomain(List<CityDatabase> cityes) {
        return cityes.stream().map(it -> it.translateToDomain()).collect(Collectors.toList());
    }
}
