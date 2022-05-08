package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiRestDisney.personajes.dao.IPersonajeDao;
import com.ApiRestDisney.personajes.entity.Personaje;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

	@Autowired
	private IPersonajeDao iPersonajeDao;

	@Override
	public List<Personaje> findAll() {
		return (List<Personaje>) iPersonajeDao.findAll();
	}

	@Override
	public Personaje save(Personaje personaje) {
		return this.iPersonajeDao.save(personaje);
	}

	@Override
	public Personaje checkPersonajeLogin(Personaje personaje) {
		return null;
	}

	@Override
	public void deletePersonaje(Personaje personaje) {
		this.iPersonajeDao.delete(personaje);

	}

	@Override
	public Personaje uptadePersonaje(Personaje personaje) {
		return this.iPersonajeDao.save(personaje);
	}

	@Override
	public Optional<Personaje> findPersonajeById(Long personajeId) {
		return this.iPersonajeDao.findById(personajeId);
	}

	@Override
	public void deletePersonaje(Long id) {
		this.iPersonajeDao.deleteById(id);

	}

	@Override
	public void deleteAllPersonajes() {
		this.iPersonajeDao.deleteAll();

	}

	@Override
	public Personaje findById(Long id) {
		return this.iPersonajeDao.findById(id).orElse(null);
	}

	@Override
	public Personaje findPersonajePorNombre(String nombre) {
		return this.iPersonajeDao.findByNombre(nombre);
	}

	@Override
	public Personaje findPersonajePorEdad(String edad) {
		return this.iPersonajeDao.findByEdad(edad);
	}

	@Override
	public Personaje findPersonajePorPeso(Double peso) {
		return this.iPersonajeDao.findByPeso(peso);
	}

}
