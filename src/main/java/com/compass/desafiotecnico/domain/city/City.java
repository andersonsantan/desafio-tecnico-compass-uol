package com.compass.desafiotecnico.domain.city;


import java.util.Objects;

public class City {
    private Long id;
    private String name;
    private String state;

    public City(Long id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(state, city.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
