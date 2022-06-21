package com.compass.desafiotecnico.api.controller;

import com.compass.desafiotecnico.api.request.CityRequest;
import com.compass.desafiotecnico.service.CityRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "city")
public class CityController {

    private CityRegistrationService registrationService;

    public CityController(CityRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public void create(@RequestBody @Valid CityRequest request) {
        registrationService.execute(request.translateToDomain());
    }





}
