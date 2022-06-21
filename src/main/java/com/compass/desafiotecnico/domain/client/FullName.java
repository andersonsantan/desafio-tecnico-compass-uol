package com.compass.desafiotecnico.domain.client;

import java.util.Objects;

public class FullName {
    private String firstName;
    private String lastName;

    @Deprecated
    public FullName() {
    }

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullName)) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) && Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
