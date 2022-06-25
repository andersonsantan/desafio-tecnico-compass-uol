package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCitiesByNameGateway;
import com.compass.desafiotecnico.gateway.GetCitiesByStateGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetCitiesByNameOrStateServiceTest {

    @Mock
    GetCitiesByNameGateway getCitiesByNameGateway;
    @Mock
    GetCitiesByStateGateway getCitiesByStateGateway;
    @InjectMocks
    GetCitiesByNameOrStateService nameOrStateService;

    List<City> cities;

    @BeforeEach
    void setUp() {
        City rjCity = new City(1L, "Rio deJaneiro", "RJ");
        City spCity = new City(2L, "Sãp Paulo", "SP");
        cities = Arrays.asList(rjCity, spCity);
    }

    @Test
    @DisplayName("Should return a list of cities by name")
    void shouldReturnAListOfCitiesByName() {
        Map<String, String> params = new HashMap();
        params.put("name", "Rio de Janeiro");

        Mockito.when(getCitiesByNameGateway.execute(any())).thenReturn(cities);
        List<City> responseCities = nameOrStateService.execute(params);

        assertEquals(cities.size(), responseCities.size());
        verify(getCitiesByNameGateway, times(1)).execute(any());

    }

    @Test
    @DisplayName("Should return a list of cities by state")
    void shoulReturAListOfCitiesByState() {
        Map<String, String> params = new HashMap();
        params.put("state", "RJ");

        Mockito.when(getCitiesByStateGateway.execute(any())).thenReturn(cities);
        List<City> responseCities = nameOrStateService.execute(params);

        assertEquals(cities.size(), responseCities.size());
        verify(getCitiesByStateGateway, times(1)).execute(any());

    }

    @Test
    @DisplayName("Should return an empty list if there are no query parameters")
    void shoulReturnAnEmptyListIfThereAreNoQueryParameters() {
        Map<String, String> params = new HashMap();

        List<City> responseCities = nameOrStateService.execute(params);

        assertEquals(new ArrayList<>().size(), responseCities.size());
        verify(getCitiesByStateGateway, never()).execute(any());
        verify(getCitiesByNameGateway, never()).execute(any());

    }
}