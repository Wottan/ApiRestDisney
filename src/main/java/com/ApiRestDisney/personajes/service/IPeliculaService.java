package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import com.ApiRestDisney.personajes.entity.Pelicula;

public interface IPeliculaService {

	public List<Pelicula> findAll();

	public Pelicula save(Pelicula pelicula);

	public void delete(Pelicula pelicula);

	public Pelicula uptade(Pelicula pelicula);

	public Optional<Pelicula> findById(Long id);

	public void delete(Long id);

	public void deleteAll();

}
