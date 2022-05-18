package com.ApiRestDisney.personajes.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ApiRestDisney.personajes.entity.Genero;

public interface IGeneroDao extends CrudRepository<Genero, Long> {

	public Optional<Genero> findById(Long id);

	public Genero findByNombre(String nombre);
}
