package com.compass.desafiotecnico.gateway.database;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.database.model.CityDatabase;
import com.compass.desafiotecnico.gateway.database.repository.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class GetCitiesByNameDatabaseTest {
    
    @Mock
    CityRepository repository;
    
    @InjectMocks
    GetCitiesByNameDatabase getCitiesByNameDatabase;


    @Test
    @DisplayName("Deve buscar todas as cidades pelo nome e retornar no metodo")
    void name() {
        CityDatabase rj = new CityDatabase(1L, "Rio de Janeiro", "RJ");
        CityDatabase sp = new CityDatabase(2L, "São Paulo", "SP");
        List<CityDatabase> cities = Arrays.asList(rj, sp);

        Mockito.when(repository.findAllByName(any())).thenReturn(cities);

        List<City> getCities = getCitiesByNameDatabase.execute(any(String.class));

        verify(repository, times(1)).findAllByName(any());
        assertTrue(getCities.contains(rj.translateToDomain()));
        assertTrue(getCities.contains(sp.translateToDomain()));
        assertTrue(getCities.size() == cities.size());
    }
}