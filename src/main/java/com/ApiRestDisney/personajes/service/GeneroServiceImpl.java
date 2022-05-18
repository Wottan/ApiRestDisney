package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiRestDisney.personajes.dao.IGeneroDao;
import com.ApiRestDisney.personajes.entity.Genero;

@Service
public class GeneroServiceImpl implements IGeneroService {

	@Autowired
	private IGeneroDao generoDao;

	@Override
	public List<Genero> findAll() {
		return (List<Genero>) this.generoDao.findAll();
	}

	@Override
	public Genero save(Genero genero) {
		return this.generoDao.save(genero);
	}

	@Override
	public void delete(Genero genero) {
		this.generoDao.delete(genero);
	}

	@Override
	public Genero uptade(Genero genero) {
		return this.generoDao.save(genero);
	}

	@Override
	public void delete(Long id) {
		this.generoDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		this.generoDao.deleteAll();
	}

	@Override
	public Optional<Genero> findByGeneroId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero findById(Long id) {
		return this.generoDao.findById(id).orElse(null);
	}

	@Override
	public Genero findByNombre(String nombre) {
		return this.generoDao.findByNombre(nombre);
	}

}
