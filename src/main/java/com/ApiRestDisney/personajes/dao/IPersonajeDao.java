package com.ApiRestDisney.personajes.dao;

import org.springframework.data.repository.CrudRepository;

import com.ApiRestDisney.personajes.entity.Personaje;

public interface IPersonajeDao extends CrudRepository<Personaje, Long> {

	public Personaje findByNombre(String nombre);

	public Personaje findByPeso(Double peso);

	public Personaje findByEdad(String edad);

}
