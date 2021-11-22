package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pasteles")
public class Pastel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	@Column
	private String nombre;
	
	@NotNull
	@Column
	private String tipo;
	
	@NotNull
	@Column
	private short pesoMin;
	
	@NotNull
	@Column
	private String adicional;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public short getPesoMin() {
		return pesoMin;
	}

	public void setPesoMin(short pesoMin) {
		this.pesoMin = pesoMin;
	}
	
	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	
	
}
