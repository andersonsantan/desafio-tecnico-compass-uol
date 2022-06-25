package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCitiesByNameGateway;
import com.compass.desafiotecnico.gateway.database.model.CityDatabase;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityRegistrationDatabaseTest {

    @Mock
    CityRepository cityRepository;

    @Mock
    GetCitiesByNameGateway getCityesByNameGateway;

    @InjectMocks
    CityRegistrationDatabase cityRegistrationDatabase;
    CityDatabase cityDatabase;

    @BeforeEach
    void setUp() {
        cityDatabase = new CityDatabase(1L,"Rio de Janeiro", "RJ");
    }

    @Test
    @DisplayName("Should successfully register a city")
    void ShouldSuccessFullyRegister() {
        lenient().when(getCityesByNameGateway.execute(any(String.class))).thenReturn(new ArrayList<City>());
        lenient().when(cityRepository.save(any(CityDatabase.class))).thenReturn(cityDatabase);

        City register = cityRegistrationDatabase.execute(cityDatabase.translateToDomain());

        assertEquals(register.getName(), cityDatabase.getName());
        assertEquals(register.getId(), cityDatabase.getId());
        verify(getCityesByNameGateway, times(1)).execute(register.getName());

    }
    @Test
    @DisplayName("Should throw an exception when there is a registered city")
    void ShouldThrowAnExceptionWhenThereIsARegistered() {
        lenient().when(getCityesByNameGateway.execute(any(String.class))).thenReturn(new ArrayList<City>());

        verify(cityRepository, never()).findAllByName(any());
        verify(cityRepository, never()).findAllByState(any());
        assertThrows(RuntimeException.class, ()->{
            cityRegistrationDatabase.execute(cityDatabase.translateToDomain());
        });


    }

}