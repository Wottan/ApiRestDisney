package com.ApiRestDisney.personajes.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ApiRestDisney.personajes.entity.Pelicula;
import com.ApiRestDisney.personajes.service.IPeliculaService;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

	@Autowired
	private IPeliculaService peliculaService;

	@GetMapping("/movies")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getPersonajes(@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long idGenre) {

		List<Pelicula> peliculas = this.peliculaService.findAll();

		Predicate<Pelicula> filtro = new Predicate<Pelicula>() {
			@Override
			public boolean test(Pelicula t) {
				return false;
			}
		};

		if (titulo != null) {
			filtro = (m) -> m.getTitulo().equals(titulo);
			if (idGenre != null) {
				filtro = (m) -> m.getTitulo().equals(titulo) && m.getGenero().getId().equals(idGenre);
			}
			return new ResponseEntity<>(peliculas.stream().filter(filtro).map(p -> this.toPeliculaMap(p)),
					HttpStatus.OK);
		}
		if (idGenre != null) {
			filtro = (m) -> m.getGenero() != null && m.getGenero().getId().equals(idGenre);
			return new ResponseEntity<>(peliculas.stream().filter(filtro).map(p -> this.toPeliculaMap(p)),
					HttpStatus.OK);
		}

		return new ResponseEntity<>(peliculas.stream().map(p -> this.toPeliculaMap(p)), HttpStatus.OK);
	}

	private Pelicula toPeliculaMap(Pelicula pelicula) {
		Pelicula retorno = new Pelicula();
		retorno.setImagen(pelicula.getImagen());
		retorno.setTitulo(pelicula.getTitulo());
		retorno.setCreateAt(pelicula.getCreateAt());
		return retorno;
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<?> getGenero(@PathVariable Long id) {
		Pelicula pelicula = this.peliculaService.findById(id).orElse(null);
		if (pelicula != null) {
			return new ResponseEntity<>(pelicula, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PostMapping("/movies")
	public ResponseEntity<?> addGenero(@RequestBody Pelicula pelicula) {
		if (this.peliculaService.findByTitulo(pelicula.getTitulo()) == null) {
			this.peliculaService.save(pelicula);
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/movies")
	public void delete(@RequestBody Pelicula pelicula) {
		if (pelicula == null) {
			this.peliculaService.deleteAll();
		} else {
			this.peliculaService.delete(pelicula);
		}
	}

	@DeleteMapping("/movies/{id}")
	public void delete(@PathVariable Long id) {
		this.peliculaService.delete(id);
	}

	@PutMapping("/movies/{id}")
	public ResponseEntity<?> updateGenero(@PathVariable(value = "id") Long id, @RequestBody Pelicula pelicula) {
		Pelicula peliculaDB = this.peliculaService.findById(id).orElse(null);
		if (peliculaDB != null) {
			peliculaDB.setTitulo(peliculaDB.getTitulo());
			peliculaDB.setCalificacion(pelicula.getCalificacion());
			peliculaDB.setGenero(pelicula.getGenero());
			peliculaDB.setImagen(pelicula.getImagen());
			this.peliculaService.uptade(peliculaDB);
			return new ResponseEntity<>(peliculaDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
