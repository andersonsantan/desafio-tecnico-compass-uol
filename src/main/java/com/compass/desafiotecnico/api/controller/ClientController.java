package com.compass.desafiotecnico.api.controller;

import com.compass.desafiotecnico.api.request.client.ClientRequest;
import com.compass.desafiotecnico.api.response.ResponseMessage;
import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    ClientRegistrationService clientRegistrationService;
    GetClientByNameService getClientByNameService;
    GetClientByIdService getClientByIdService;
    RemoveClientService removeClientService;

    UpdateClientService updateClientService;

    public ClientController(ClientRegistrationService clientRegistrationService, GetClientByNameService getClientByNameService, GetClientByIdService getClientByIdService, RemoveClientService removeClientService, UpdateClientService updateClientService) {
        this.clientRegistrationService = clientRegistrationService;
        this.getClientByNameService = getClientByNameService;
        this.getClientByIdService = getClientByIdService;
        this.removeClientService = removeClientService;
        this.updateClientService = updateClientService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public ResponseMessage create(@RequestBody @Valid ClientRequest clientRequest) {
        Client save = clientRegistrationService.execute(clientRequest.translateToDomain());
        return new ResponseMessage(
                200,
                "OK",
                "Registered customer with id " + save.getId()
        );
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Client> findByName(@RequestParam String name){
        return getClientByNameService.execute(name);
    }

    @GetMapping(path =  "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Client findById(@PathVariable(name = "id") Long id){
        return getClientByIdService.execute(id);
    }

    @DeleteMapping(path =  "/{id}")
    public ResponseMessage remove(@PathVariable(name = "id") Long id){
        removeClientService.execute(id);
        return new ResponseMessage(
                200,
                "Ok",
                "Client with id "+id+" successfully removed"
        );
    }

    @PatchMapping(path =  "/{id}")
    @Transactional
    public ResponseMessage update(@RequestBody ClientRequest clientRequest, @PathVariable(name = "id") Long id){
        updateClientService.execute(id, clientRequest.getName());
        return new ResponseMessage(
                200,
                "OK",
                "Client name successfully updated");
    }

}
