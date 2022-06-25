package com.compass.desafiotecnico.gateway;

import com.compass.desafiotecnico.domain.city.City;

public interface GetCityByIdGateway {
    City execute(Long id);
}
