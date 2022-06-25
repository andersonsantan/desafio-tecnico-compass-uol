package com.compass.desafiotecnico.gateway.database.repository;

import com.compass.desafiotecnico.gateway.database.model.ClientDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientDatabase, Long> {
    List<ClientDatabase> findAllByName(String name);
}
