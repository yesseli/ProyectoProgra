package com.progra3.datos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos", schema = "sql3414679")

public class PagosEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name= "Fecha")
	private String Fecha;
	
	@Column (name="Monto")
	private int Monto;
	
	@Column (name="Tarjeta")
	private Long Tarjeta;
	
	@Column (name="Estado")
	private String Estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getMonto() {
		return Monto;
	}

	public void setMonto(int monto) {
		Monto = monto;
	}

	public Long getTarjeta() {
		return Tarjeta;
	}

	public void setTarjeta(Long tarjeta) {
		Tarjeta = tarjeta;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
	
}
