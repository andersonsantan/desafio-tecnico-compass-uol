package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.CityRegistrationGateway;
import com.compass.desafiotecnico.service.exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityRegistrationServiceTest {

    @Mock
    CityRegistrationGateway registrationGateway;
    @InjectMocks
    CityRegistrationService registrationService;
    City city;

    @BeforeEach
    void setUp() {
        city = new City(1L, "Rio de Janeiro", "RJ");
    }

    @Test
    @DisplayName("Should successfully register a city")
    void ShouldSuccessFullyRegister() {
        lenient().when(registrationGateway.execute(any(City.class))).thenReturn(city);
        City register = registrationService.execute(city);

        assertEquals(register.getName(), city.getName());
        assertEquals(register.getId(), city.getId());
        verify(registrationGateway, times(1)).execute(city);
    }

    @Test
    @DisplayName("Should throw an exception if the city exists")
    void ShouldThrowlException() {
        lenient().when(registrationGateway.execute(any(City.class))).thenThrow(new RuntimeException("message"));

        assertThrows(ServiceException.class, () -> {
            registrationService.execute(city);
        });

    }


}