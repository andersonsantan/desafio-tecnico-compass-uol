package com.compass.desafiotecnico.gateway.database.repository;

import com.compass.desafiotecnico.gateway.database.model.CityDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityDatabase, Long> {
    List<CityDatabase> findAllByName(String name);
    List<CityDatabase> findAllByState(String state);
}
