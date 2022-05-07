package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import com.ApiRestDisney.personajes.entity.Personaje;

public interface IPersonajeService {

	public List<Personaje> findAll();

	public Personaje save(Personaje personaje);;

	public Personaje findPersonaje(Personaje personaje);

	public Personaje checkPersonajeLogin(Personaje personaje);

	public void deletePersonaje(Personaje personaje);

	public Personaje uptadePersonaje(Personaje personaje);

	public Optional<Personaje> findPersonajeById(Long personajeId);

	public void deletePersonaje(Long id);

	public void deleteAllPersonaje();

	public Personaje findById(Long id);

}
