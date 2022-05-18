package com.ApiRestDisney.personajes.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.ApiRestDisney.personajes.entity.Genero;
import com.ApiRestDisney.personajes.entity.Personaje;
import com.ApiRestDisney.personajes.service.IGeneroService;

@RestController
@RequestMapping("/api")
public class GeneroRestController {

	@Autowired
	private IGeneroService generoService;

	@GetMapping("/genre")
	public List<Genero> findAll() {
		return this.generoService.findAll();
	}

	@GetMapping("/genre/{id}")
	public ResponseEntity<?> getGenero(@PathVariable Long id) {
		Genero genero = this.generoService.findById(id);
		if (genero != null) {
			return new ResponseEntity<>(genero, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PostMapping("/genre")
	public ResponseEntity<?> addGenero(@RequestBody Genero genero) {
		if (this.generoService.findByNombre(genero.getNombre()) == null) {
			this.generoService.save(genero);
			return new ResponseEntity<>(genero, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/genre")
	public void delete(@RequestBody Genero genero) {
		if (genero == null) {
			this.generoService.deleteAll();
		} else {
			this.generoService.delete(genero);
		}
	}

	@PutMapping("/genre/{id}")
	public ResponseEntity<?> updateGenero(@PathVariable(value = "id") Long id, @RequestBody Genero genero) {
		Genero generoDB = this.generoService.findById(id);
		if (generoDB != null) {
			generoDB.setNombre(genero.getNombre());
			generoDB.setImagen(genero.getImagen());
			this.generoService.uptade(generoDB);
			return new ResponseEntity<>(generoDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
