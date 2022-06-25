package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.city.City;

import java.util.List;

public interface GetCitiesByStateGateway {
    List<City> execute(String state);
}
