package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;
import com.ApiRestDisney.personajes.entity.Genero;

public interface IGeneroService {

	public List<Genero> findAll();

	public Genero save(Genero genero);

	public void delete(Genero genero);

	public Genero uptade(Genero genero);

	public Optional<Genero> findByGeneroId(Long id);

	public Genero findById(Long id);

	public Genero findByNombre(String nombre);

	public void delete(Long id);

	public void deleteAll();
}
