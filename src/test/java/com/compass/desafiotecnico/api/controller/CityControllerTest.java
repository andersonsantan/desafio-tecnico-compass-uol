package com.compass.desafiotecnico.api.controller;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.service.CityRegistrationService;
import com.compass.desafiotecnico.service.GetCitiesByNameOrStateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CityRegistrationService registrationService;

    @MockBean
    GetCitiesByNameOrStateService getCitiesByNameOrStateService;

    City city;

    @BeforeEach
    void setUp() {
        city = new City(1L, "Rio de Janeiro", "RJ");
    }

    @Test
    @DisplayName("Should return ok when request is sent")
    void shouldReturnOkWhenRequestIsSent() throws Exception {
        when(registrationService.execute(any())).thenReturn(city);

        this.mockMvc.perform(post("/city")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"null\",\"name\":\"Rio de Janeiro\",\"state\":\"RJ\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return a name message cannot be blank")
    void ShouldReturnANameMessageCannotBeBlank() throws Exception {
        when(registrationService.execute(any())).thenReturn(city);

        this.mockMvc.perform(post("/city")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"null\",\"name\":\"\",\"state\":\"RJ\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Should return a state message cannot be blank")
    void ShouldReturnAStateMessageCannotBeBlank() throws Exception {
        when(registrationService.execute(any())).thenReturn(city);

        this.mockMvc.perform(post("/city")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"null\",\"name\":\"Rio de Janeiro\",\"state\":\"\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Deve retornar uma lista de cidades pelo nome")
    void teste01() throws Exception {
        List<City> cities = Arrays.asList(city);
        when(getCitiesByNameOrStateService.execute(any())).thenReturn(cities);

        this.mockMvc.perform(get("/city?name=Rio de Janeiro"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve retornar uma lista de cidades pelo estado")
    void teste02() throws Exception {
        List<City> cities = Arrays.asList(city);
        when(getCitiesByNameOrStateService.execute(any())).thenReturn(cities);

        this.mockMvc.perform(get("/city?state=RJ"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}