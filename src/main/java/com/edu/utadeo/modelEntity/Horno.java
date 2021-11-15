package com.edu.utadeo.modelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hornos")
public class Horno implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private String marca;
	@Column
	private float vEstimadoActual;
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getvEstimadoActual() {
		return vEstimadoActual;
	}
	public void setvEstimadoActual(float vEstimadoActual) {
		this.vEstimadoActual = vEstimadoActual;
	}
	

	
}
