package com.compass.desafiotecnico.gateway.database.model;

import com.compass.desafiotecnico.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class CityDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    public CityDatabase(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public static CityDatabase translateToModel(City city){
        return new CityDatabase(city.getName(), city.getState());
    }


    public City translateToDomain(){
        return new City(id, name, state);
    }
}
