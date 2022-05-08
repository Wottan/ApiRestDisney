package com.ApiRestDisney.personajes.controller;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ApiRestDisney.personajes.entity.Personaje;
import com.ApiRestDisney.personajes.service.IPersonajeService;

@RestController
@RequestMapping("/api")
public class PersonajeRestController {

	@Autowired
	private IPersonajeService personajeService;

	@GetMapping("/characters")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getPersonajes(@RequestParam(required = false) String edad,
			@RequestParam(required = false) Double peso, @RequestParam(required = false) String nombre) {

		Predicate<Personaje> filtro = new Predicate<Personaje>() {
			@Override
			public boolean test(Personaje t) {
				return false;
			}
		};

		if (edad != null) {
			filtro = (p) -> p.getEdad().equals(edad);
			if (nombre != null && peso != null) {
				filtro = (p) -> p.getEdad().equals(edad) && p.getPeso().equals(peso) && p.getNombre().equals(nombre);
			} else if (nombre != null) {
				filtro = (p) -> p.getEdad().equals(edad) && p.getNombre().equals(nombre);
			} else if (peso != null) {
				filtro = (p) -> p.getEdad().equals(edad) && p.getPeso().equals(peso);
			}
			return new ResponseEntity<>(this.personajeService.findAll().stream().filter(filtro), HttpStatus.OK);
		}
		if (nombre != null) {
			filtro = (p) -> p.getNombre().equals(nombre);
			if (peso != null) {
				filtro = (p) -> p.getNombre().equals(nombre) && p.getPeso().equals(peso);
			}
			return new ResponseEntity<>(this.personajeService.findAll().stream().filter(filtro), HttpStatus.OK);
		}

		if (peso != null) {
			filtro = (p) -> p.getPeso().equals(peso);
			return new ResponseEntity<>(this.personajeService.findAll().stream().filter(filtro), HttpStatus.OK);

		}

		return new ResponseEntity<>(this.personajeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/characters", params = "")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getPersonajes(@RequestParam(required = false) String[] params) {
		System.out.println("Ingreso " + params);
		Personaje personaje;

		personaje = this.personajeService.findPersonajePorNombre("");
		if (personaje != null) {
			return new ResponseEntity<>(personaje, HttpStatus.OK);
		}

		return new ResponseEntity<>(this.personajeService.findAll(), HttpStatus.CREATED);
	}

	@GetMapping("/characters/{nombre}")
	public Personaje getPersonajePorNombre(@PathVariable String nombre) {
		System.out.println("nombre");
		return this.personajeService.findPersonajePorNombre(nombre);
	}

	@GetMapping("/characters/{edad}")
	public Personaje getPersonajePorEdad(@RequestParam String edad) {
		System.out.println("edad");
		return this.personajeService.findPersonajePorEdad(edad);
	}

	@GetMapping("/characters/{peso}")
	public Personaje getPersonajePorPeso(@PathVariable Double peso) {
		return this.personajeService.findPersonajePorPeso(peso);
	}

	@PostMapping("/characters")
	public ResponseEntity<Personaje> addPersonaje(@RequestBody Personaje personaje) {
		if (this.personajeService.findPersonajePorNombre(personaje.getNombre()) == null) {
			this.personajeService.save(personaje);
			return new ResponseEntity<Personaje>(personaje, HttpStatus.CREATED);
		}
		return new ResponseEntity<Personaje>(HttpStatus.CONFLICT);

	}

	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		this.personajeService.deleteAllPersonajes();
	}
}
