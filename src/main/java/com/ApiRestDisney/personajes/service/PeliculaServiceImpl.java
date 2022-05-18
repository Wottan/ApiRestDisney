package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiRestDisney.personajes.dao.IPeliculaDao;
import com.ApiRestDisney.personajes.entity.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculaDao iPeliculaDao;

	@Override
	public List<Pelicula> findAll() {
		return (List<Pelicula>) this.iPeliculaDao.findAll();
	}

	@Override
	public Pelicula save(Pelicula pelicula) {
		return this.iPeliculaDao.save(pelicula);
	}

	@Override
	public void delete(Pelicula pelicula) {
		this.iPeliculaDao.delete(pelicula);

	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		return this.iPeliculaDao.save(pelicula);
	}

	@Override
	public Optional<Pelicula> findById(Long id) {
		return this.iPeliculaDao.findById(id);
	}

	@Override
	public void delete(Long id) {
		this.iPeliculaDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		this.iPeliculaDao.deleteAll();
	}

	@Override
	public Pelicula findByTitulo(String titulo) {
		return this.iPeliculaDao.findByTitulo(titulo);
	}
}
