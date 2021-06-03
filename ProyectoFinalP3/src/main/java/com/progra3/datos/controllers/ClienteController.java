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

import com.progra3.datos.entities.ClienteEntity;
import com.progra3.datos.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository repository;

	// Este método nos muestra la lista de los clientes que tenemos registrados
	@GetMapping
	public Iterable<ClienteEntity> findAll() {
		Iterable<ClienteEntity> listaClientes = repository.findAll();

		return listaClientes;
	}

	// Este método nos permite crear nuevos clientes
	@PostMapping
	public ClienteEntity createCliente(@RequestBody ClienteEntity clientee) {
		return repository.save(clientee);
	}

	// Nos permite buscar un cliente especifico usando el id
	@GetMapping(value = "/{id}")
	public ClienteEntity getClienteEntity(@PathVariable(name = "id") Long id) {

		Optional<ClienteEntity> clientee = repository.findById(id);

		ClienteEntity result = null;
		if (clientee.isPresent()) {
			result = clientee.get();
		}
		return result;
	}

	// Nos permite actualizar la información de los clientes seleccionandolos
	// mediante el id

	@PutMapping(value = "/{id}")
	public ClienteEntity actualizarInfoCliente(@PathVariable(name = "id") Long id,
			@RequestBody ClienteEntity clientee) {
		Optional<ClienteEntity> nCliente = repository.findById(id);

		if (nCliente.isPresent()) {

			ClienteEntity infoActual = nCliente.get();
			infoActual.setId(clientee.getId());
			infoActual.setNombre(clientee.getNombre());
			infoActual.setEdad(clientee.getEdad());
			infoActual.setSexo(clientee.getSexo());
			infoActual.setDireccion(clientee.getDireccion());
			infoActual.setFecha(clientee.getFecha());
			ClienteEntity cModificado = repository.save(infoActual);

			return cModificado;
		}
		return null;
	}

	// Permite borrar clientes de nuestra lista.

	@DeleteMapping(value = "/{id}")
	public void borrarCliente(@PathVariable(name = "id") Long id) {

		repository.deleteById(id);
	}

}
