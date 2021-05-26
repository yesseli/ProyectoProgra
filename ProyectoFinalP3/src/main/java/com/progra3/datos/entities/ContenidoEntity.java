package com.progra3.datos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenido", schema = "sql3414679")
public class ContenidoEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Resumen")
	private String Resumen;

	@Column(name = "idCategoria")
	private Long idCategoria;

	@Column(name = "IdGenero")
	private Long IdGenero;

	@Column(name = "Fecha")
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

	public String getResumen() {
		return Resumen;
	}

	public void setResumen(String resumen) {
		Resumen = resumen;
	}

	public Long getIdGenero() {

		return IdGenero;
	}

	public void setIdGenero(Long idGenero) {
		IdGenero = idGenero;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	

}
