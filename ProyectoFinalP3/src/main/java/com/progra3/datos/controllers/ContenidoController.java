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

import com.progra3.datos.entities.ContenidoEntity;
import com.progra3.datos.repositories.ContenidoRepository;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

	@Autowired
	ContenidoRepository repository;

	// Muestra una lista con el contenido que hemos registrado
	@GetMapping

	public Iterable<ContenidoEntity> findAll() {
		Iterable<ContenidoEntity> listaContenido = repository.findAll();
		return listaContenido;
	}

	// permite añadir contenido
	@PostMapping
	public ContenidoEntity createContenido(@RequestBody ContenidoEntity contenido) {
		return repository.save(contenido);
	}

	// permite buscar contenido especifico
	@GetMapping(value = "/{id}")
	public ContenidoEntity getContenidoEntity(@PathVariable(name = "id") Long id) {

		Optional<ContenidoEntity> contenido = repository.findById(id);
		ContenidoEntity busqueda = null;
		if (contenido.isPresent()) {
			busqueda = contenido.get();
		}
		return busqueda;
	}

	// nos hace posible el borrar contenido de nuestra lista
	@DeleteMapping(value = "/{id}")
	public void borrarContenido(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}

	// permite modificar los datos del contenido.

	@PutMapping(value = "/{id}")
	public ContenidoEntity modificarContenido(@PathVariable(name = "id") Long id,
			@RequestBody ContenidoEntity contenido) {

		Optional<ContenidoEntity> contenidoModificado = repository.findById(id);

		if (contenidoModificado.isPresent()) {

			ContenidoEntity infoActual = contenidoModificado.get();
			infoActual.setId(contenido.getId());
			infoActual.setNombre(contenido.getNombre());
			infoActual.setResumen(contenido.getResumen());
			infoActual.setCategoryId(contenido.getCategoryId());
			infoActual.setGeneroId(contenido.getGeneroId());
			infoActual.setFecha(contenido.getFecha());
			ContenidoEntity cModificado = repository.save(infoActual);

			return cModificado;
		}
		return null;
	}

}
