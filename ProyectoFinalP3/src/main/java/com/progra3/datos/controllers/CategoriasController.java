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

import com.progra3.datos.entities.CategoriasEntity;
import com.progra3.datos.repositories.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	CategoriasRepository repository;

	// mostrar
	@GetMapping

	public Iterable<CategoriasEntity> findAll() {
		Iterable<CategoriasEntity> listaCategorias = repository.findAll();

		return listaCategorias;
	}

	// Crear

	@PostMapping
	public CategoriasEntity createCategoria(@RequestBody CategoriasEntity categoria) {
		return repository.save(categoria);
	}

	// Buscar
	@GetMapping(value = "/{id}")
	public CategoriasEntity getCategoriasEntity(@PathVariable(name = "id") Long id) {
		Optional<CategoriasEntity> categoria = repository.findById(id);

		CategoriasEntity result = null;
		
		if(categoria.isPresent()) {
			result = categoria.get();
		}
		return result; 

	}
	
	//Borrar
	@DeleteMapping(value="/{id}")
	public void borrarCategoria(@PathVariable(name="id")Long id) {
		repository.deleteById(id);
	}
	
	//actualizar
	
	@PutMapping(value="/{id}")
	public CategoriasEntity actualizarCategoria(@PathVariable(name="id")Long id,
			@RequestBody CategoriasEntity categoria) {
		Optional <CategoriasEntity> nuevaCategoria= repository.findById(id);
		
		if (nuevaCategoria.isPresent()) {
			
			CategoriasEntity infActual = nuevaCategoria.get();
			infActual.setId(categoria.getId());
			infActual.setNombre(categoria.getNombre());
			infActual.setDescripcion(categoria.getDescripcion());
			infActual.setFecha(categoria.getFecha());
			CategoriasEntity cModificada= repository.save(infActual);
			return cModificada;
		}
		return null;
	}
	
}
