package com.compass.desafiotecnico.api.request;

import com.compass.desafiotecnico.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String state;

    public City translateToDomain() {
        return new City(name, state);
    }

}
