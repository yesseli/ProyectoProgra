package com.progra3.datos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planes", schema = "sql10416921")

public class PlanesEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name= "Nombre")
	private String Nombre;
	
	@Column (name = "Descripcion")
	private String Descripcion;
	
	@Column (name = "Monto")
	private int Monto;
	
	@Column(name= "Fecha")
	private String Fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getMonto() {
		return Monto;
	}

	public void setMonto(int monto) {
		Monto = monto;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
	
	

}
