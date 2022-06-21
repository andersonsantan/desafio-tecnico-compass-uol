package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.city.City;

import java.util.List;

public interface GetCitiesByNameGateway {
    List<City> execute(String nameCity);
}
