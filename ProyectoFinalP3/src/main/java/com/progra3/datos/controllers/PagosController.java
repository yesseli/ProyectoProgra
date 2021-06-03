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

import com.progra3.datos.entities.PagosEntity;
import com.progra3.datos.repositories.PagosRepository;

@RestController
@RequestMapping("/pagos")
public class PagosController {

	@Autowired
	PagosRepository repository;

	// Muestra la lista de pagos
	@GetMapping
	public Iterable<PagosEntity> findAll() {
		Iterable<PagosEntity> listaPagos = repository.findAll();
		return listaPagos;

	}

	// Nos permite registrar un nuevo pago

	@PostMapping
	public PagosEntity createPago(@RequestBody PagosEntity pago) {
		return repository.save(pago);

	}

	// Busca pagos especificos usando el id

	@GetMapping(value = "/{id}")
	public PagosEntity getPagosEntity(@PathVariable(name = "id") Long id) {

		Optional<PagosEntity> pago = repository.findById(id);

		PagosEntity result = null;
		if (pago.isPresent()) {
			result = pago.get();

		}
		return result;
	}

	// Permite actualizar los datos de un pago

	@PutMapping(value = "/{id}")
	public PagosEntity actualizarPagos(@PathVariable(name = "id") Long id, @RequestBody PagosEntity pago) {

		Optional<PagosEntity> nPago = repository.findById(id);

		if (nPago.isPresent()) {
			PagosEntity pagoActual = nPago.get();
			pagoActual.setId(pago.getId());
			pagoActual.setFecha(pago.getFecha());
			pagoActual.setMonto(pago.getMonto());
			pagoActual.setTarjeta(pago.getTarjeta());
			pagoActual.setEstado(pago.getEstado());

			return repository.save(pagoActual);
		}
		return null;

	}

	// Permite borrar un pago
	@DeleteMapping(value = "/{id}")
	public void borrarPago(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
}
