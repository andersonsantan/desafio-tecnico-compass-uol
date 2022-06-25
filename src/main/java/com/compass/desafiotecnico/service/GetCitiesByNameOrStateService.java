package com.compass.desafiotecnico.service;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.gateway.GetCitiesByNameGateway;
import com.compass.desafiotecnico.gateway.GetCitiesByStateGateway;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GetCitiesByNameOrStateService {

    GetCitiesByNameGateway getCitiesByNameGateway;
    GetCitiesByStateGateway getCitiesByStateGateway;

    public GetCitiesByNameOrStateService(GetCitiesByNameGateway getCitiesByNameGateway, GetCitiesByStateGateway getCitiesByStateGateway) {
        this.getCitiesByNameGateway = getCitiesByNameGateway;
        this.getCitiesByStateGateway = getCitiesByStateGateway;
    }

    public List<City> execute(Map<String, String> params){
        if (params.containsKey("name")){
            return getCitiesByNameGateway.execute(params.get("name"));
        }else if (params.containsKey("state")){
            return getCitiesByStateGateway.execute(params.get("state"));
        }else {
            return new ArrayList<>();
        }

    }

}
