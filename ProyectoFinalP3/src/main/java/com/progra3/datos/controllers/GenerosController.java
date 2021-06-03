package com.progra3.datos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.datos.entities.GenerosEntity;
import com.progra3.datos.repositories.GenerosRepository;

@RestController
@RequestMapping("/generos")
public class GenerosController {

	@Autowired
	GenerosRepository repository;

	// muestra la lista de generos que tenemos registrados
	@GetMapping
	public Iterable<GenerosEntity> findAll() {
		Iterable<GenerosEntity> listaGeneros = repository.findAll();
		return listaGeneros;

	}

	// permite crear un nuevo genero
	@PostMapping
	public GenerosEntity createGenero(@RequestBody GenerosEntity genero) {
		return repository.save(genero);
	}

	// permite buscar un genero especifico

	@GetMapping(value = "/{id}")
	public GenerosEntity getGenerosEntity(@PathVariable(name = "id") Long id) {

		Optional<GenerosEntity> genero = repository.findById(id);

		GenerosEntity result = null;
		if (genero.isPresent()) {
			result = genero.get();

		}
		return result;
	}

	// permite actualizar las informacion de un genero en especifico

	@PutMapping(value = "/{id}")
	public GenerosEntity actualizarGenero(@PathVariable(name = "id") Long id, @RequestBody GenerosEntity genero) {
		Optional<GenerosEntity> nGenero = repository.findById(id);

		if (nGenero.isPresent()) {

			GenerosEntity infActual = nGenero.get();
			infActual.setId(genero.getId());
			infActual.setNombre(genero.getNombre());
			infActual.setDescripcion(genero.getDescripcion());
			infActual.setFecha(genero.getFecha());
			GenerosEntity gModificado = repository.save(infActual);
			return gModificado;
		}
		return null;
	}

	// permite borrar un genero

	@DeleteMapping(value = "/{id}")
	public void borrarGenero(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}

}
