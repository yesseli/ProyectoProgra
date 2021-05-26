package com.progra3.datos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.datos.entities.ContenidoEntity;
import com.progra3.datos.repositories.ContenidoRepository;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

	
	@Autowired
	ContenidoRepository repository;
	
	
	@GetMapping
	
	public Iterable<ContenidoEntity>findAll(){
		Iterable<ContenidoEntity>listaContenido=repository.findAll();
		return listaContenido;
	}
	
}


