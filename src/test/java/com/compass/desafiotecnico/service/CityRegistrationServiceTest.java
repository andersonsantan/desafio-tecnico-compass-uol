package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.CityRegistrationGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class CityRegistrationServiceTest {

    @Mock
    CityRegistrationGateway registrationGateway;
    @InjectMocks
    CityRegistrationService registrationService;


    @Test
    @DisplayName("Should successfully register a city")
    void ShouldSuccessFullyRegisterACity() {
        City city = new City("Rio de Janeiro", "RJ");
        lenient().when(registrationGateway.execute(any())).thenReturn(city);

        assertNotNull(city.getName());
        assertNotNull(city.getState());
    }

    //TODO https://mmarcosab.medium.com/criando-mocks-e-escrevendo-testes-unit%C3%A1rios-com-junit-5-f54e6407bd7c



}