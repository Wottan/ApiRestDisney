package com.ApiRestDisney.personajes.controller;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ApiRestDisney.personajes.entity.Personaje;
import com.ApiRestDisney.personajes.service.IPeliculaService;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

	@Autowired
	private IPeliculaService iPeliculaService;


}
