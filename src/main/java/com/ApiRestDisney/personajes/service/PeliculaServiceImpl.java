package com.ApiRestDisney.personajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ApiRestDisney.personajes.dao.IPeliculaDao;
import com.ApiRestDisney.personajes.entity.Pelicula;

public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculaDao iPeliculaDao;

	@Override
	public List<Pelicula> findAll() {
		return (List<Pelicula>) this.iPeliculaDao.findAll();
	}

	@Override
	public Pelicula save(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return this.iPeliculaDao.save(pelicula);
	}

	@Override
	public void delete(Pelicula pelicula) {
		this.iPeliculaDao.delete(pelicula);

	}

	@Override
	public Pelicula uptade(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return this.iPeliculaDao.save(pelicula);
	}

	@Override
	public Optional<Pelicula> findById(Long id) {
		// TODO Auto-generated method stub
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
}
