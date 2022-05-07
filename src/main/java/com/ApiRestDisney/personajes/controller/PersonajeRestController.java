package com.ApiRestDisney.personajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.ApiRestDisney.personajes.entity.Personaje;
import com.ApiRestDisney.personajes.service.IPersonajeService;

@RestController
@RequestMapping("/api")
public class PersonajeRestController {

	@Autowired
	private IPersonajeService personajeService;

	@GetMapping("/characters")
	@ResponseStatus(HttpStatus.OK)
	public List<Personaje> getPersonajes() {
		return this.personajeService.findAll();
	}

}
