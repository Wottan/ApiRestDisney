package com.ApiRestDisney.personajes.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.ApiRestDisney.personajes.entity.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long> {

	public Optional<Pelicula> findById(Long id);

	public Pelicula findByTitulo(String titulo);

	public List<Pelicula> findAll(Sort sort);
}
