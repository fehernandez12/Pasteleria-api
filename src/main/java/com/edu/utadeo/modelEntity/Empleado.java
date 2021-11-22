package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SuppressWarnings("serial")
@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@NotNull
	@Column
	private String nombres;
	
	@NotNull
	@Column
	private String apellidos;
	
	@NotNull
	@Column
	private float salarioActual;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_empleado.id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoEmpleado tipoEmpleado;
	
	@OneToOne
	@JoinColumn(name="persona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Persona persona;
	
	
	//Getters and Setters

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public float getSalarioActual() {
		return salarioActual;
	}

	public void setSalarioActual(float salarioActual) {
		this.salarioActual = salarioActual;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
