package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.city.City;

public interface GetCityByNameAndStateGateway {
    City execute(String name, String state);
}
