package com.edu.utadeo.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long nombre; 
	
	@Column
	private String uMed;
	
	//Getters and setters

	public long getNombre() {
		return nombre;
	}

	public void setNombre(long nombre) {
		this.nombre = nombre;
	}

	public String getuMed() {
		return uMed;
	}

	public void setuMed(String uMed) {
		this.uMed = uMed;
	}
	
	
	
}
