package com.compass.desafiotecnico.api.response;

import com.compass.desafiotecnico.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityResponse {
    private Long id;
    private String name;
    private String state;

    public static CityResponse translateToResponse(City city){
        return new CityResponse(city.getId(),city.getName(), city.getState());
    }

}
