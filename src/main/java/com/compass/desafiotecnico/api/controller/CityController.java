package com.compass.desafiotecnico.api.controller;

import com.compass.desafiotecnico.api.request.city.CityRequest;
import com.compass.desafiotecnico.api.response.CityResponse;
import com.compass.desafiotecnico.api.response.ResponseMessage;
import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.service.CityRegistrationService;
import com.compass.desafiotecnico.service.GetCitiesByNameOrStateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "city")
public class CityController {

    private CityRegistrationService registrationService;
    private GetCitiesByNameOrStateService getCitiesByNameOrStateService;

    public CityController(CityRegistrationService registrationService, GetCitiesByNameOrStateService getCitiesByNameOrStateService) {
        this.registrationService = registrationService;
        this.getCitiesByNameOrStateService = getCitiesByNameOrStateService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public ResponseMessage create(@RequestBody @Valid CityRequest request) {
        City save = registrationService.execute(request.translateToDomain());
        return new ResponseMessage(
                200,
                "OK",
                "Registered city with id " + save.getId()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponse> findByName(@RequestParam Map<String, String> params) {
        return getCitiesByNameOrStateService.execute(params)
                .stream()
                .map(CityResponse::translateToResponse)
                .collect(Collectors.toList());
    }
}
