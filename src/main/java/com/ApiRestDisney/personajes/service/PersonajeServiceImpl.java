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
	IPersonajeDao iPersonajeDao;

	@Override
	public List<Personaje> findAll() {
		// TODO Auto-generated method stub
		return (List<Personaje>) iPersonajeDao.findAll();
	}

	@Override
	public Personaje save(Personaje personaje) {
		return this.iPersonajeDao.save(personaje);
	}

	@Override
	public Personaje findPersonaje(Personaje personaje) {
		// TODO Auto-generated method stub
		return iPersonajeDao.findPersonaje(personaje);
	}

	@Override
	public Personaje checkProfesorLogin(Personaje personaje) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePersonaje(Personaje personaje) {
		this.iPersonajeDao.delete(personaje);

	}

	@Override
	public Personaje uptadePersonaje(Personaje personaje) {
		// TODO Auto-generated method stub
		return this.iPersonajeDao.save(personaje);
	}

	@Override
	public Optional<Personaje> findPersonajeById(Long personajeId) {
		// TODO Auto-generated method stub
		return this.iPersonajeDao.findById(personajeId);
	}

	@Override
	public void deletePersonaje(Long id) {
		this.iPersonajeDao.deleteById(id);

	}

	@Override
	public void deleteAllPersonaje() {
		this.iPersonajeDao.deleteAll();

	}

	@Override
	public Personaje findById(Long id) {
		// TODO Auto-generated method stub
		return this.iPersonajeDao.findById(id).orElse(null);
	}

}
