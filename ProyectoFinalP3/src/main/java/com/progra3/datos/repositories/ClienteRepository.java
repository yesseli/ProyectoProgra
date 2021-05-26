package com.progra3.datos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.progra3.datos.entities.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
