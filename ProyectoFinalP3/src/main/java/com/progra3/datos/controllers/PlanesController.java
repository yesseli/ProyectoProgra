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

import com.progra3.datos.entities.PlanesEntity;
import com.progra3.datos.repositories.PlanesRepository;

@RestController
@RequestMapping("/planes")
public class PlanesController {

	@Autowired
	PlanesRepository repository;

	// Muestra la lista de planes que tengamos
	@GetMapping
	public Iterable<PlanesEntity> findAll() {
		Iterable<PlanesEntity> listPlanes = repository.findAll();

		return listPlanes;

	}

	// Permite crear nuevos planes

	@PostMapping
	public PlanesEntity createPlan(@RequestBody PlanesEntity plan) {
		return repository.save(plan);
	}

	// Permite buscar un plan especifico por medio del id

	@GetMapping(value = "/{id}")
	public PlanesEntity getPlanesEntity(@PathVariable(name = "id") Long id) {
		Optional<PlanesEntity> plan = repository.findById(id);

		PlanesEntity result = null;
		if (plan.isPresent()) {
			result = plan.get();

		}
		return result;
	}

	// Permite actualizar la informacion de los planes que tengamos

	@PutMapping(value = "/{id}")
	public PlanesEntity actualizarPlanes(@PathVariable(name = "id") Long id, @RequestBody PlanesEntity plan) {
		Optional<PlanesEntity> nPlan = repository.findById(id);

		if (nPlan.isPresent()) {

			PlanesEntity planActual = nPlan.get();
			planActual.setId(plan.getId());
			planActual.setNombre(plan.getNombre());
			planActual.setDescripcion(plan.getDescripcion());
			planActual.setMonto(plan.getMonto());
			planActual.setFecha(plan.getFecha());
			PlanesEntity planModificado = repository.save(planActual);

			return planModificado;

		}
		return null;

	}

	// Permite borrar los planes que tengamos en nuestra lista
	@DeleteMapping(value = "/{id}")
	public void borrarPlan(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}

}
