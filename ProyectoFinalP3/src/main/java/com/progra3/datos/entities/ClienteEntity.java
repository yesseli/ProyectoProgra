package com.progra3.datos.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "cliente", schema = "sql3414679")

public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "Nombre")
	private String Nombre;
	
	@Column (name= "Edad")
	private int Edad;
	
	@Column (name= "Sexo")
	private String Sexo;
	
	@Column(name= "Direccion")
	private String Direccion; 
	
	@Column(name="Fecha")
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

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
	
	

}
