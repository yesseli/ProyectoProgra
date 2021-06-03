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

	@Column(name = "categoryId")
	private Long categoryId;

	@Column(name = "generoId")
	private Long generoId;

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

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}

	
	

}
