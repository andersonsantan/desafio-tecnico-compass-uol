package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.CityRegistrationGateway;
import com.compass.desafiotecnico.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CityRegistrationService {
    CityRegistrationGateway cityRegistrationGateway;


    public CityRegistrationService(CityRegistrationGateway cityRegistrationGateway) {
        this.cityRegistrationGateway = cityRegistrationGateway;
    }

    public void execute(City city) {
        try {
            cityRegistrationGateway.execute(city);
        } catch (RuntimeException e) {
            throw new ServiceException("Unable to register", e);
        }
    }
}
