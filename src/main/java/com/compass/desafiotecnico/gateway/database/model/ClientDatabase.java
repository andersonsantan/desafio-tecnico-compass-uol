package com.compass.desafiotecnico.gateway.database.model;

import com.compass.desafiotecnico.domain.city.City;
import com.compass.desafiotecnico.domain.client.Client;
import com.compass.desafiotecnico.domain.client.Sexo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class ClientDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private SexoDatabase sexDataBase;
    @Column(name = "birthDate")
    private LocalDate birthDateDataBasa;
    @Column(name = "age")
    private int ageDataBase;

    private Long cityId;

    public ClientDatabase(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ClientDatabase translateToModel(Client client, Long cityId) {
        return new ClientDatabase(client.getId(),
                client.getName(),
                SexoDatabase.valueOf(client.getSex().toString()),
                client.getBirthDate(),
                client.getAge(),
                cityId);
    }
    public static ClientDatabase translateToModel(Client client) {
        return new ClientDatabase(client.getId(), client.getName());
    }

    public Client translateToDomain(City city) {
        return new Client(
                id,
                name,
                Sexo.valueOf(sexDataBase.name()),
                birthDateDataBasa,
                ageDataBase,
                city
                );
    }

}

