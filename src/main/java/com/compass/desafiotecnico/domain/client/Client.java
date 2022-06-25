package com.compass.desafiotecnico.domain.client;

import com.compass.desafiotecnico.domain.city.City;
import lombok.Setter;

import java.time.LocalDate;

public class Client {
    private Long id;
    @Setter
    private String name;
    private Sexo sex;
    private LocalDate birthDate;
    private int age;
    private City city;

    public Client(Long id, String name, Sexo sex, LocalDate birthDate, int age, City city) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.age = age;
        this.city = city;
    }

    public Client(String name, Sexo sex, LocalDate birthDate, int age, City city) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.age = age;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sexo getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    public Long getCityId() {
        return city.getId();
    }

    public String getNameCity() {
        return city.getName();
    }

    public String getNameState() {
        return city.getState();
    }

}
