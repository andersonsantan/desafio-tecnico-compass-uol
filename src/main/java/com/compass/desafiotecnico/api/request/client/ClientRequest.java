package com.compass.desafiotecnico.api.request.client;

import com.compass.desafiotecnico.api.request.city.CityRequest;
import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.domain.client.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClientRequest {
    @NotBlank
    private String name;
    @NotNull
    private SexoRequest sex;
    @NotNull
    private LocalDate birthDate; //USar o jackson para Ser/Des do abjeto
    @NotNull
    private int age;
    @NotNull
    private CityRequest city;

    public Client translateToDomain() {
        return new Client(
                name,
                Sexo.valueOf(sex.name()),
                birthDate,
                age,
                city.translateToDomain()
        );
    }
    public Client translateToDomain(Long id) {
        return new Client(
                id,
                name,
                Sexo.valueOf(sex.name()),
                birthDate,
                age,
                city.translateToDomain()
        );
    }

}
