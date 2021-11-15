package com.edu.utadeo.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresas")
public class Empresa {
	@Id
	private long nit;
	@Column
	private String nombre;
	@Column
	private String direccion;
	
	
	//Getters and Setters
	public long getNit() {
		return nit;
	}
	public void setNit(long nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
